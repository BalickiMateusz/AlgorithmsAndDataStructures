package Lab12;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graf {
	
	class WagaComparator implements Comparator<Krawedz> {
	    public int compare(Krawedz a, Krawedz b)
	    {
	    	int wynik = b.getWaga() - a.getWaga();    	
	    	return wynik;	    	
	    }
	}
	
	public class Krawedz {
	
		private int cel;
		private int waga;
		
		public Krawedz(int cel, int waga) {
			
			this.cel = cel;
			this.waga = waga;
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
		
	}
		
	private OneWayLinkedListWithHead <OneWayLinkedListWithHead<Krawedz>> listaSasiedztwa;
	private HashMap<String, Integer> mapa = new HashMap<String, Integer>();
	private HashMap<Integer, String> mapa2 = new HashMap<Integer, String>();
	
	public Graf() {
	
		listaSasiedztwa = new OneWayLinkedListWithHead <OneWayLinkedListWithHead<Krawedz>>();
	}
	
	public void dodajWezly(HashMap<String, Integer> mapa) {
		
		System.out.println("Dodano wezly ");
		this.mapa = mapa;
		
		for(HashMap.Entry<String, Integer> entry : mapa.entrySet()){
		    mapa2.put(entry.getValue(), entry.getKey());
		}
		
		for(String x: mapa.keySet()) {
					
			System.out.println(listaSasiedztwa.size()+" - "+x);
			listaSasiedztwa.add(new OneWayLinkedListWithHead<Krawedz>());			
		}
		System.out.println();
	}
	
	public void dodajKrawedz(String zrodlo, String cel, int waga) {
		
		if(listaSasiedztwa.get(mapa.get(zrodlo)) == null) {
			
			System.out.println("Nieprawidlowe zrodlo!");
		}
		
		if(listaSasiedztwa.get(mapa.get(cel)) == null) {
			
			System.out.println("Nieprawidlowy cel!");
		}
		else {
						
			listaSasiedztwa.get(mapa.get(zrodlo)).add(new Krawedz(mapa.get(cel), waga));
			System.out.println("Dodano krawêdz: "+zrodlo+" ---"+waga+"---> "+cel);
		}				
	}
	
	public void wyswietlGraf() {
		
		for(int i=0; i< listaSasiedztwa.size(); i++) {
			
			OneWayLinkedListWithHead<Krawedz> lista = listaSasiedztwa.get(i);
			
			for(int j=0; j<lista.size(); j++) {
				
				Krawedz krawedz = lista.get(j);			
				//System.out.println("Wezel "+i+" jest polaczony z wezlem "+krawedz.getCel()+" - waga "+krawedz.getWaga());
				System.out.println(mapa2.get(i)+" ---"+krawedz.getWaga()+"---> "+mapa2.get(krawedz.getCel()));
			}
		}
	}
	
	public void AlgorytmDijkstry(String zrodloNapis) {
		
		int zrodlo = mapa.get(zrodloNapis);
		
		try {
			
		int liczbaWezlow = listaSasiedztwa.size();
		
		int[] dystans = new int[liczbaWezlow];
		Set<Integer> sprawdzone = new HashSet<Integer>();	
		
		PriorityQueueHeap<Krawedz> kolejka = new PriorityQueueHeap(new WagaComparator());
		
		for(int i=0; i<liczbaWezlow;i++) {
			
			dystans[i] = Integer.MAX_VALUE;
		}
		
		dystans[zrodlo] = 0;
		
		kolejka.enqueue(new Krawedz(zrodlo, 0));
		
		while(sprawdzone.size()!=liczbaWezlow) {
						
			int u = kolejka.dequeue().getCel();	
			System.out.println("Nasze u:"+u);
			sprawdzone.add(u);
//*****************************************************************************************
			int odleglosc = -1;
			int nowaOdleglosc = -1;
			
			for(int i=0; i<listaSasiedztwa.get(u).size(); i++) {
				
				Krawedz krawedz = listaSasiedztwa.get(u).get(i);
				System.out.println(krawedz.getCel()+" "+krawedz.getWaga());

				if(!sprawdzone.contains(krawedz.getCel())) {
					
					odleglosc = krawedz.getWaga();
					nowaOdleglosc = dystans[u] + odleglosc;
					
					if(nowaOdleglosc < dystans[krawedz.getCel()]) {
						
						dystans[krawedz.getCel()] = nowaOdleglosc;
					}
					
					kolejka.enqueue(krawedz);
				}
			}
		}
		
		for(int i=0; i<dystans.length; i++) {
			
			 if(dystans[i]!=Integer.MAX_VALUE) {
				System.out.println("Minimalna odleg³oœæ z miasta: "+ mapa2.get(zrodlo) + " do miasta: " + mapa2.get(i) + " wynosi " + dystans[i]);
			}
		}

		}catch(EmptyQueueException e) {
		
		e.printStackTrace();
		}
	}
	
	public void DFS(String sNapis) {
		
		int s = mapa.get(sNapis);
		
		int liczbaWezlow = listaSasiedztwa.size();	
		boolean[] odwiedzone = new boolean[liczbaWezlow];
		
		wykonajDFS(s, odwiedzone);
	}
	
	private void wykonajDFS(int s, boolean[] odwiedzone) {
		
		odwiedzone[s] = true;
		System.out.println(mapa2.get(s)+" ");
		
		for(int i=0; i<listaSasiedztwa.get(s).size(); i++) {
			
			int liczba = listaSasiedztwa.get(s).get(i).getCel();
			
			if(!odwiedzone[liczba]) {
				
				wykonajDFS(liczba, odwiedzone);
			}
		}
		
	}
}
