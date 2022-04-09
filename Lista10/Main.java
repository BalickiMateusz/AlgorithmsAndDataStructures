package Lab10;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


		
		/*FrequencyOfChars frequency = new FrequencyOfChars("Pliczek");		
		HuffmanTree huffmanTree = new HuffmanTree(frequency.Frequency());
		
		huffmanTree.BuildTree();		
		frequency.ZakodujPlik((huffmanTree.kodyZnak�w()));*/
	

	public class Main {
		
		private static FrequencyOfChars frequency;
		private static LinkedHashMap<String, Integer> czestotliwoscZnakow;
		private static HuffmanTree huffmanTree;
		private static LinkedHashMap<String, String> kodyZnakow;
		
		public static void KomunikatyMenu() {
			System.out.println("\nMenu :");
			System.out.println("1 : Wczytaj plik tekstowy i oblicz cz�stotliwo�� wyst�powania znak�w w tek�cie");
			System.out.println("2 : Utw�rz drzewo Huffmana i wygeneruj kod");
			System.out.println("3 : Zakoduj plik tekstowy - do nazwy zostanie dodana ko�c�wka *Zakodowany.txt");	
			System.out.println("4 : Odszyfruj zakodowany plik tekstowy");	
			System.out.println("0 : Wyj�cie");
		}
		
		public static void main(String[] args) {	
			
		int Opcja;
		Scanner sc = new Scanner(System.in);
		
		KomunikatyMenu();
		
		while(sc.hasNext()) {
			
			Opcja = sc.nextInt();
			sc.nextLine();
			
			if(Opcja!=0) {
				
				switch(Opcja) {
				
				case 1:	
					System.out.println("Prosz� poda� nazw� pliku (bez ko�c�wki .txt): ");
					String napis = sc.nextLine();					
					
					frequency = new FrequencyOfChars(napis);
					
					czestotliwoscZnakow = frequency.Frequency();	
					
					System.out.println("\nCz�stotliwo�� wyst�powania znak�w w tek�cie: ");				
					
					for(Map.Entry<String,Integer> entry: czestotliwoscZnakow.entrySet()) {	
						
						String key = entry.getKey();
							key.toCharArray();
						if(key.charAt(0)==32) {
							key="space";
						}
						else if(key.charAt(0)==9) {
							key="tab";
						}
						
						System.out.printf ("%5s %10s %10s", key,"-", entry.getValue());
						System.out.println();
					}
					
					KomunikatyMenu();
					break;
						
				case 2:	
					huffmanTree = new HuffmanTree(czestotliwoscZnakow);
					huffmanTree.BuildTree();
					huffmanTree.WypiszWszerz();
					kodyZnakow = huffmanTree.kodyZnak�w();
						
					Iterator<Map.Entry<String, Integer>> itr = czestotliwoscZnakow.entrySet().iterator();
					 
					for(Map.Entry<String,String> entry: kodyZnakow.entrySet()) {	
						
						Map.Entry<String,Integer> entry2 = itr.next();
						
						String key = entry.getKey();
						if(key.charAt(0)==32) {
							key="space";
						}
						else if(key.charAt(0)==9) {
							key="tab";
						}
						
						System.out.printf ("%5s %5s %5s %5s %5s",key ,"-", entry2.getValue(),"-", entry.getValue());
						System.out.println();
					}
					KomunikatyMenu();
					break;
				
				case 3:		
					frequency.ZakodujPlik(kodyZnakow);
					
					KomunikatyMenu();
					break;
					
				case 4:		
					frequency.OdszyfrujPlik(kodyZnakow);					
					KomunikatyMenu();
					break;
															
				default:
				{
					System.out.println("Brak wyboru");
					KomunikatyMenu();
					break;
				}
					
				}
			}
			else {
				System.out.println("Zako�czono operowanie na tek�cie");
				break;
			}
		}
	}
}

