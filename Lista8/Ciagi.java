package Lab8;

import java.util.ArrayList;
import java.util.Collections;

public class Ciagi {

	ArrayList<Integer> list;
	
	public Ciagi() {
	}
	
	public ArrayList<Integer> ciagA(int i){		
		
		list = new ArrayList();
		
		int liczba = 1;
		
		while(liczba < i) {
			
			list.add(liczba);
			liczba = 3*liczba +1;	
		}
		
		Collections.reverse(list);
		
		return list;
	}
	
	public ArrayList<Integer> ciagB(int i){		
		
		list = new ArrayList();
		
		int j = 1;
		int liczba=1;				
	
		while(liczba < i) {
						
			liczba = (int) Math.pow(2, j)-1;
			list.add(liczba);
			j++;
		}
		
		Collections.reverse(list);
		
		return list;
	}
	
	public ArrayList<Integer> ciagC(int i){		
		
		list = new ArrayList();
		
		int liczba = 1;
		int j = 1;
		
		while(liczba < i) {
			
			list.add(liczba);
			liczba = (int) Math.pow(2, j)+1;
			j++;
		}
		
		Collections.reverse(list);
		
		return list;
	}
	
	public ArrayList<Integer> ciagD(int i){		
		
		list = new ArrayList();
		
		int liczbaFib = 1;
		int popLiczbaFib = 0;
		int temp;		
		
		while(liczbaFib < i) {
	
			list.add(liczbaFib);
			
			temp = liczbaFib;			
			liczbaFib+=popLiczbaFib;
			popLiczbaFib = temp;
			
		}
		
		Collections.reverse(list);
		
		return list;
	}
	
	public ArrayList<Integer> ciagE(int i){		
		
		list = new ArrayList();
		
		int liczba = (int) i/2;
		
		while(liczba >=1) {
			
			list.add(liczba);
			liczba = (int) (liczba * 0.75);
		}
		
		return list;
	}
}
