package Labki13;

public class LasZbiorowRozlacznych {
	
	private int[] root;
	private int[] wysokoscDrzewa;
	private int liczbaElementow;
	
	public LasZbiorowRozlacznych(int liczbaElementow) {
		
		this.root = new int[liczbaElementow];
		this.wysokoscDrzewa = new int[liczbaElementow];
		this.liczbaElementow = liczbaElementow;
		utworzZbioryJednoelementowe();
	}
	
	public void utworzZbioryJednoelementowe() {
		
		for(int i=0; i<liczbaElementow; i++) {
			
			root[i]=i;
		}
	}
	
	//Zwraca reprezentanta zbioru, do ktorego nalezy element
	public int WyszukajReprezentanta(int element) {
		
		if(root[element]!=element) {
			
			root[element] = WyszukajReprezentanta(root[element]);
		}
		
		return root[element];
	}
	
	//Laczy zbiory zawierajace elementA oraz elementB
	public void Union(int elementA, int elementB) {
		
		int reprezentantA = WyszukajReprezentanta(elementA);
		int reprezentantB = WyszukajReprezentanta(elementB);
		
		if(reprezentantA == reprezentantB) {
			return;
		}
		
		if(wysokoscDrzewa[reprezentantA] < wysokoscDrzewa[reprezentantB]) {
			
			root[reprezentantA] = reprezentantB;
		}
		else if(wysokoscDrzewa[reprezentantA] > wysokoscDrzewa[reprezentantB]) {
			
			root[reprezentantB] = reprezentantA;
		}
		else {
			
			root[reprezentantB] = reprezentantA;
			wysokoscDrzewa[reprezentantA] = wysokoscDrzewa[reprezentantA]+1;
		}
	}
}
