package Lab10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;

import Lab10.HuffmanTree.Node;

import java.util.LinkedHashMap;



public class FrequencyOfChars {
	
	private String nazwaPliku;
	private LinkedHashMap<String, Integer> mapa;
	private ArrayList<String> tekst = new ArrayList<String>();
	
	public FrequencyOfChars(String nazwaPliku){
		this.nazwaPliku = nazwaPliku;
		mapa = new LinkedHashMap<String, Integer>();
	}
	
	public LinkedHashMap<String, Integer> Frequency() {
		

		try(BufferedReader odczyt = new BufferedReader(new FileReader(new File(nazwaPliku+".txt"), Charset.forName("UTF-8")))) {
			
			String linia;
			
			while((linia = odczyt.readLine()) != null) {
				tekst.add(linia);
				for(Character znak : linia.toCharArray()) {
					
					int licznik = mapa.containsKey(znak.toString()) ? mapa.get(znak.toString()) : 0;
					mapa.put(znak.toString(), licznik+1);
				}
			}
			
			odczyt.close();
			System.out.println("Wczytano plik tekstowy o nazwie: "+nazwaPliku+".txt !");
			} catch (IOException e) {
				System.out.println("Nie mozna odczytac pliku!");
				e.printStackTrace();
			}
		return mapa;
	}
	
	public void ZakodujPlik(LinkedHashMap<String, String> kody) {
		

		try(BufferedWriter zapis = new BufferedWriter(new FileWriter(new File(nazwaPliku+"Zakodowany.txt"), Charset.forName("UTF-8")))) {
			
			for(String linia : tekst) {
				
				for(Map.Entry<String,String> entry: kody.entrySet()) {
					linia = linia.replace(entry.getKey(), entry.getValue());				
				}
				zapis.write(linia+"\n");
				System.out.println(linia);
			}
		
			zapis.close();
			} catch (IOException e) {
				System.out.println("Nie mozna zapisac do pliku!");
				e.printStackTrace();
			}
		System.out.println("\nZakodowano plik!");
		return;
	}
	
	public void OdszyfrujPlik(LinkedHashMap<String, String> kody) {
		

		try(BufferedReader odczyt = new BufferedReader(new FileReader(new File(nazwaPliku+".txt"), Charset.forName("UTF-8")));
			BufferedWriter zapis = new BufferedWriter(new FileWriter(new File(nazwaPliku+"Rozszyfrowany.txt"), Charset.forName("UTF-8"))))
		{
			String linia;
			
			while((linia = odczyt.readLine()) != null) {
				for(Map.Entry<String,String> entry: kody.entrySet()) {
					linia = linia.replace(entry.getValue(), entry.getKey());				
				}
				zapis.write(linia+"\n");
				System.out.println(linia);
			}
		
			odczyt.close();
			} catch (IOException e) {
				System.out.println("Blad operacji na pliku!");
				e.printStackTrace();
			}
		System.out.println("\nRozszyfrowano plik!");
		return;
	}
}
