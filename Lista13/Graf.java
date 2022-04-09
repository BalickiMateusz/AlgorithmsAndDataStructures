package Labki13;

import java.util.Comparator;

public class Graf {
	
	class WagaComparator implements Comparator<Krawedz> {
	    public int compare(Krawedz a, Krawedz b)
	    {
	    	int wynik = b.getWaga() - a.getWaga();    	
	    	return wynik;	    	
	    }
	}
	
	public class Krawedz {
	
		private int zrodlo;
		private int cel;
		private int waga;
		
		public Krawedz(int zrodlo, int cel, int waga) {
			
			this.zrodlo = zrodlo;
			this.cel = cel;
			this.waga = waga;
		}
		
		public int getZrodlo() {
			return zrodlo;
		}


		public void setZrodlo(int zrodlo) {
			this.zrodlo = zrodlo;
		}
		
		public int getCel() {
			return cel;
		}

		public void setCel(int cel) {
			this.cel = cel;
		}

		public int getWaga() {
			return waga;
		}

		public void setWaga(int waga) {
			this.waga = waga;
		}

		@Override
		public String toString() {
			return zrodlo+" ---["+waga+"]--- "+cel;
			
		}
		
		@Override
	    public boolean equals(Object b) {
	  	   
			if (!(b instanceof Krawedz)) {
	            return false;
	        }
		
	        if (b == this) {
	            return true;
	        }
	         
	        Krawedz k = (Krawedz) b;
	        
	        return ((this.getCel() == k.getCel()) && (this.getWaga() == k.getWaga()) && (this.getZrodlo() == k.getZrodlo()));	        	
		}
	}
		
	private OneWayLinkedListWithHead <OneWayLinkedListWithHead<Krawedz>> listaSasiedztwa;
	private int vertexCount=0;
	private int edgeCount=0;
	
	public Graf() {
	
		listaSasiedztwa = new OneWayLinkedListWithHead <OneWayLinkedListWithHead<Krawedz>>();
	}
	
	public int getVertexCount() {
		return vertexCount-1;
	}
	
	public int getEdgeCount() {
		return edgeCount;
	}
	
	public String dodajWezly(int liczbaWezlow) {
		
		String napis = "Dodano wezly: \n";
		
		for(int i=0; i<liczbaWezlow; i++) {
					
			napis += listaSasiedztwa.size()+"\n";
			listaSasiedztwa.add(new OneWayLinkedListWithHead<Krawedz>());			
		}
	
		vertexCount += liczbaWezlow;
		return napis;
	}
	
	public void dodajWezel() {
		
		listaSasiedztwa.add(new OneWayLinkedListWithHead<Krawedz>());				
		vertexCount += 1;
	}
	
	public String dodajKrawedz(int zrodlowyWezel, int cel, int waga) {
		
		edgeCount += 1;
		
		if(listaSasiedztwa.get(zrodlowyWezel) == null) {
			
			return "Nieprawidlowe zrodlo!";
		}
		
		if(listaSasiedztwa.get(cel) == null) {

			return "Nieprawidlowy cel!";
		}
		else {	
			
			Krawedz k = new Krawedz(zrodlowyWezel, cel, waga);			
			listaSasiedztwa.get(zrodlowyWezel).add(k);
			listaSasiedztwa.get(cel).add(new Krawedz(cel, zrodlowyWezel, waga));
			 
			return "Dodano krawêdz: "+k;
		}				
	}
	
	public void wyswietlListeSasiedztwa() {
		
		for(int i=0; i< listaSasiedztwa.size(); i++) {
			
			OneWayLinkedListWithHead<Krawedz> lista = listaSasiedztwa.get(i);
			
			for(int j=0; j<lista.size(); j++) {
				
				Krawedz krawedz = lista.get(j);			
				//System.out.println("Wezel "+i+" jest polaczony z wezlem "+krawedz.getCel()+" - waga "+krawedz.getWaga());
				System.out.println(krawedz);
			}
		}
	}
	
	public void wyswietlGraf() {
		
		ArrayList<Krawedz> lista = KrawedzieBezDuplikatow();
		
		for(int i=0; i< lista.size(); i++) {
		
			System.out.println(lista.get(i));
		}
	}
		
	public void AlgorytmKruskala() {
		
		try {
			
		PriorityQueueHeap<Krawedz> kolejka = new PriorityQueueHeap(new WagaComparator());
		ArrayList<Krawedz> lista = KrawedzieBezDuplikatow();
		
		for(int i=0; i< lista.size(); i++) {
		
				kolejka.enqueue(lista.get(i));				
		}
		
		LasZbiorowRozlacznych las = new LasZbiorowRozlacznych(listaSasiedztwa.size());
		
		Graf MinimalneDrzewoRozpinajace = new Graf();
		
		int licznik = 0;
		
		MinimalneDrzewoRozpinajace.dodajWezly(listaSasiedztwa.size());
	
		while(licznik < lista.size()-1) {
			
			Krawedz krawedz = kolejka.dequeue();
			
			int reprezentantA = las.WyszukajReprezentanta(krawedz.getZrodlo());
			int reprezentantB = las.WyszukajReprezentanta(krawedz.getCel());	
			
			if(reprezentantA != reprezentantB) {
							
				MinimalneDrzewoRozpinajace.dodajKrawedz(krawedz.getZrodlo(), krawedz.getCel(), krawedz.getWaga());
				
				las.Union(reprezentantA, reprezentantB);				
			}
			licznik++;
		}
		
		MinimalneDrzewoRozpinajace.wyswietlGraf();
		System.out.println(MinimalneDrzewoRozpinajace.SumaWag());
		
		}catch(EmptyQueueException e) {
		
		e.printStackTrace();
		}
	}
	
	public int SumaWag() {
		
		int suma = 0;
		
		ArrayList<Krawedz> lista = KrawedzieBezDuplikatow();
		
		for(int i=0; i< lista.size(); i++) {
		
			Krawedz krawedz = lista.get(i);	
			suma += krawedz.getWaga();
		}
		
		return suma;
	}
	
	public ArrayList<Krawedz> KrawedzieBezDuplikatow(){
		
		ArrayList<Krawedz> lista = new ArrayList<Krawedz>();
		
		for(int i=0; i< listaSasiedztwa.size(); i++) {
			
			for(int j=0; j<listaSasiedztwa.get(i).size(); j++) {
				
				Krawedz krawedz = listaSasiedztwa.get(i).get(j);
				
				if(!lista.contains(new Krawedz(krawedz.getCel(), krawedz.getZrodlo(), krawedz.getWaga()))) {
					
					lista.add(krawedz);
				}
				
			}
		}
		
		return lista;
	}
	
	public ArrayList<String> zwrocKrawedzie() {
		
		ArrayList<Krawedz> lista1 = KrawedzieBezDuplikatow();
		ArrayList<String> lista2 = new ArrayList<String>();
		
		for(Krawedz x: lista1) {
			
			String napis = x.getZrodlo()+" "+x.getCel()+" "+x.getWaga();
			lista2.add(napis);
		}
		
		return lista2;
	}
}
