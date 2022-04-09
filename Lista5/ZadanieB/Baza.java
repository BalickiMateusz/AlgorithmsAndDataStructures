package Zadanie5b;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Baza {

	private L2KCzS<Pracownik> lista;

	public Baza() {
		lista = new L2KCzS<Pracownik>();
	}

	public L2KCzS<Pracownik> getLista() {
		return lista;
	}

	public void setLista(L2KCzS<Pracownik> lista) {
		this.lista = lista;
	}
	
	public void Dodaj(Pracownik prac) {
		int ind = 0;
		int flag = 0;
		int i = 0;
		while((flag!=1) && (i<lista.size())) {
			Pracownik x = lista.get(i);
			if(prac.getPESEL()<x.getPESEL()) {
				ind = i;
				flag=1;
			}else  {
				ind = i+1;
			}
			++i;
		}
		lista.add(ind,prac);
	}
	
	public void Usun(int index) {
		lista.remove(index);
	}
	
	public void WyswietlBaze() {
		for(Pracownik x:lista) {
			System.out.println(x);
		}
	}
	
	public void WyswietlPracownika(int index) {
		System.out.println(lista.get(index));
	}
	
	public double ŒredniaPensja() {
		double suma=0;
		for(Pracownik x:lista) {
			suma+=x.getPensja();
		}
		return suma/lista.size();
	}
	
	public int IluPonizejSredniej() {
		int liczba=0;
		double srednia = ŒredniaPensja();
		
		for(Pracownik x:lista) {
			if(x.getPensja()<srednia) {
				liczba++;
			}
		}
		return liczba;
	}
	
	public void Odczyt() {
		
		lista.clear();
		
		try (ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream("Baza2.ser"))) {
			boolean flag = true;
			while(flag) {
				
				Object pracownik = odczyt.readObject();
				
				if(pracownik!=null) {
					lista.add((Pracownik) pracownik );
				}else {
					flag = false;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Pomyslny odczyt!");
	}
	
	public void Zapis() {
		try (ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream("Baza2.ser"))) 
		{	
			for(int i=0; i<lista.size() ;i++) {
				zapis.writeObject(lista.get(i));
			}	
			zapis.writeObject(null);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println("Pomyslny zapis!");
	}
	
	@Override
	public String toString() {
		return "Firma [lista=" + lista + "]";
	}
	
}
