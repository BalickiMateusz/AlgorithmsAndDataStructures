package Zadanie;

import Zadanie.ArrayList;
import java.util.Iterator;

public class ListaKart {
	
	private ArrayList<Karta> lista;
	private Karta karta = new Karta();
	
	public ListaKart() {
		lista = new ArrayList<Karta>();
	}


	public ArrayList<Karta> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Karta> lista) {
		this.lista = lista;
	}
	
	public void Wypelnij() {
		
		while(karta.getWartosc()!=0) {
			int ind = 0;
			int flag = 0;
			int i = 0;
			
			if(lista.isEmpty()) {
				lista.add(karta);
			}else {
				
			//for(Karta x: lista) {
				
				/*if(karta.getWartosc()<x.getWartosc()) {
					index = lista.indexOf(x);
				}else if((karta.getWartosc()==x.getWartosc()) && (karta.getKolor()<=x.getKolor())) {
					index = lista.indexOf(x);
				}else if((karta.getWartosc()>x.getWartosc()))*/
				/*if(karta.getWartosc()>x. etWartosc()) {
					index = lista.indexOf(x)+1;
				}else if(karta.getWartosc()==x.getWartosc()) {
					if(karta.getKolor()>=x.getKolor()) {
						index = lista.indexOf(x)+1;
					}else if(karta.getKolor()<x.getKolor()) {
						index = lista.indexOf(x);
						System.out.println("To tu: "+karta+index);
					}
					else{
					System.out.println("co to ma byc");	
					}
				}
			}*/
				while((flag!=1) && (i<lista.size())) {
					Karta x = lista.get(i);
					if(karta.getWartosc()<x.getWartosc()) {
						ind = i;
						flag=1;
					}else if(karta.getWartosc()==x.getWartosc()) {
						if(karta.getKolor()<x.getKolor()) {
							ind = i;
							flag=1;
						}else {
							ind = i+1;
						}
					}else  {
						ind = i+1;
					}
				
					++i;
				}
				
			lista.add(ind,karta);
			}	
			karta = new Karta();
		}
	}
	
	
	public void Wyswietl() {
			System.out.println(lista);	
	}
	 
	
	/*public void Wyswietl() {
		if(lista!=null) {
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));
		}
		}else {
			System.out.println("Lista jest pusta!");
		}
	}*/
	
	 public void Licznosc() {
		System.out.println(lista.size());
	}

	public void ShowByValue(int value) {
		 Iterator<Karta> iter = lista.iterator();
		 
		 while(iter.hasNext()) {
			 Karta x = iter.next();
			 if(x.getWartosc()==value) {
				 System.out.println(x);
			 }
		 }
	}
	
	public void ShowByColour(int colour) {
		 for(Karta x : lista) {
			 if(x.getKolor()==colour) {
				 System.out.println(x);
			 }
		 }
	}
	
	public ArrayList<Karta> DeleteDuplicates() {
		ArrayList<Karta> nowaLista = new ArrayList<Karta>();
		
		for(Karta x : lista) {
			 if(!nowaLista.contains(x)) {
				 nowaLista.add(x);
			 }
		 }
		return nowaLista;
	}
	
	public void DodajAsy() {
		for(int i=0;i<3;i++) {
		lista.add(0, new Karta(1,0));
		}
	}
	
	@Override
	public String toString() {
		return "Lista "+lista;
	}
	
}
