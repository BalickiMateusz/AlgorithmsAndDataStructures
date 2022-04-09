package Lab11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Skorowidz {
	
	private RBTree<String> tree;
	private Komparator komparator;
	private String nazwaPliku;
	
	public Skorowidz(){
		
		komparator = new Komparator();
		tree = new RBTree<String>(komparator);		
	}
	
	public void Utworz(String nazwaPliku) {
		
		this.nazwaPliku = nazwaPliku;
		
		try(BufferedReader odczyt = new BufferedReader(new FileReader(new File(nazwaPliku+".txt"), Charset.forName("UTF-8")));
			BufferedWriter zapis = new BufferedWriter(new FileWriter(new File(nazwaPliku+"Skorowidz.txt"), Charset.forName("UTF-8"))))
		{
			String linia;
			int numerWiersza = 1;
			
			while((linia = odczyt.readLine()) != null) {
				
				String[] slowa = linia.split("[^\\p{L}]");
				
				for(int i=0; i<slowa.length; i++) {
					
					tree.DodajNoda(slowa[i], numerWiersza);
				}
				
				numerWiersza++;
			}
			
			ArrayList<String> alfabetycznie = tree.DrzewoAlfabetycznie();
			
			for(String x: alfabetycznie) {
				
				zapis.write(x);
				zapis.newLine();
			}
			
			odczyt.close();
			zapis.close();
			} catch (IOException e) {
				
				System.out.println("Blad operacji na pliku!");
				e.printStackTrace();
			}
		System.out.println("\nUtworzono skorowidz!");
		return;
	}
	
	public void Aktualizuj() {
		
		try(BufferedWriter zapis = new BufferedWriter(new FileWriter(new File(nazwaPliku+"Skorowidz.txt"), Charset.forName("UTF-8")))){
			
			ArrayList<String> alfabetycznie = tree.DrzewoAlfabetycznie();
			
			for(String x: alfabetycznie) {
				
				zapis.write(x);
				zapis.newLine();
			}
			
			zapis.close();
		} catch (IOException e) {
			
			System.out.println("Blad operacji na pliku!");
			e.printStackTrace();
		}
	}
	
	public void WypiszWszerz() {
		
		tree.WypiszWszerz();
	}
	
	public void WyswietlSkorowidz() {
		
		ArrayList<String> alfabetycznie = tree.DrzewoAlfabetycznie();
		
		for(String x: alfabetycznie) {
			
			System.out.println(x);
		}
	}
	
	public void UsunSlowo(String slowo) {
		
		tree.DeleteKey(slowo);
		Aktualizuj();
		
		System.out.println("Usuniêto pomyœlnie i zaktualizowano plik tekstowy!");
	}
}
