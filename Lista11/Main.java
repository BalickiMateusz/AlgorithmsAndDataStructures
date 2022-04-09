package Lab11;

import java.util.Scanner;

	public class Main {
		
		private static Skorowidz skorowidz = new Skorowidz();
		
		public static void KomunikatyMenu() {
			System.out.println("\nMenu :");
			System.out.println("1 : Wczytaj plik tekstowy i utwórz skorowidz (zapis w pliku *Skorowidz.txt)");
			System.out.println("2 : Wyœwietl skorowidz w kolejnoœci alfabetycznej (przegl¹d in-order)");
			System.out.println("3 : Wyœwietl skorowidz (przejœcie drzewa wszerz)");	
			System.out.println("4 : Usuñ wybrane s³owo (usuwanie wêz³a z drzewa)");	
			System.out.println("0 : Wyjœcie");
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
					System.out.println("Proszê podaæ nazwê pliku (na przyk³ad Przyk³ad, Aforyzm, bez koñcówki .txt): ");
					String napis = sc.nextLine();					
					System.out.println(napis);
					skorowidz.Utworz(napis);
			
					KomunikatyMenu();
					break;
						
				case 2:							
					System.out.println("Skorowidz wypisany w kolejnoœci alfabetycznej: \n");
					skorowidz.WyswietlSkorowidz();
					
					KomunikatyMenu();
					break;
				
				case 3:						
					System.out.println("Skorowidz wypisany wszerz: \n");
					skorowidz.WypiszWszerz();				
						
					KomunikatyMenu();
					break;
					
				case 4:	
					System.out.println("Proszê podaæ s³owo do usuniêcia: ");
					String slowo = sc.nextLine();	
					skorowidz.UsunSlowo(slowo);
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
				System.out.println("Zakoñczono operowanie na tekœcie");
				break;
			}
		}
	}
}

