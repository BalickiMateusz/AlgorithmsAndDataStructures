package Labki13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public class ObslugaPliku {
	
	private String nazwaPliku = "Domyslna";
	
	public ObslugaPliku() {

	}
	
	public Graf Odczyt(String nazwaPliku) {
		
		this.nazwaPliku = nazwaPliku;
		Graf graf = new Graf();
		
		try(BufferedReader odczyt = new BufferedReader(new FileReader(new File(nazwaPliku+".txt")))) {
			
			String linia;
			
			
			String[] znaki = odczyt.readLine().split(" ");
			
			int liczbaWezlow = Integer.parseInt(znaki[0]);
			int liczbaPolaczen = Integer.parseInt(znaki[1]);
			
			if((liczbaWezlow >= 1) && (liczbaWezlow<=20)) {
				
			graf.dodajWezly(liczbaWezlow+1);
			}else {
				
				System.out.println("Liczba wêz³ów musi nale¿eæ do przedzia³o [1,20]!");
			}
			
			if((liczbaPolaczen >= 0) && (liczbaPolaczen<=190)) {
			
			for(int x = 0; x<liczbaPolaczen; x++) {
				
				znaki = odczyt.readLine().split(" ");
				
				int i = Integer.parseInt(znaki[0]);
				int j = Integer.parseInt(znaki[1]);
				int k = Integer.parseInt(znaki[2]);
				
				if((1<=i) && (j<=liczbaWezlow) && (1<=k) && (k<=500)) {
					graf.dodajKrawedz(i, j, k);
				}
				else {
					System.out.println("Podano nieprawidlowe dane!");
					System.out.println("Krawedz "+i+" ---["+k+"]--- "+j+" nie zostala dodana!");
				}
			}
			
			}else {
				
				System.out.println("Liczba wêz³ów musi nale¿eæ do przedzia³o [0,190]!");
			}
			
			odczyt.close();
			
			System.out.println("Wczytano graf z pliku tekstowego o nazwie: "+nazwaPliku+".txt !");
			} catch (IOException e) {
				System.out.println("Nie mozna odczytac pliku!");
				e.printStackTrace();
			}
		
		return graf;
	}
	
	public void Zapis(Graf graf) {
		
		try(BufferedWriter zapis = new BufferedWriter(new FileWriter(new File(nazwaPliku+"Zapisany.txt")))) {
			
			int n = graf.getVertexCount();
			int m = graf.getEdgeCount();
			
			if((n >= 1) && (n<=20) && (m >= 0) && (m<=190)) {
				
				zapis.write(n+" "+m+"\n");
				
				ArrayList<String> lista = graf.zwrocKrawedzie();
				String[] znaki;
			
				for(int x=0; x<m; x++) {
				
					znaki = lista.get(x).split(" ");
				
					int i = Integer.parseInt(znaki[0]);
					int j = Integer.parseInt(znaki[1]);
					int k = Integer.parseInt(znaki[2]);
				
					if((1<=i) && (j<=n) && (1<=k) && (k<=500)) {
					
						zapis.write(i+" "+j+" "+k+"\n");
					}
					else {
						System.out.println("Podano b³êdne wartoœci!");
						break;
					}
				}
			
			}
			zapis.close();
			} catch (IOException e) {
				System.out.println("Nie mozna zapisac do pliku!");
				e.printStackTrace();
			}
		System.out.println("\nZapisano graf!");
		return;
	}
}
