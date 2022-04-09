package Lab11;

import java.util.Scanner;

	public class Main {
		
		private static Skorowidz skorowidz = new Skorowidz();
		
		public static void KomunikatyMenu() {
			System.out.println("\nMenu :");
			System.out.println("1 : Wczytaj plik tekstowy i utw�rz skorowidz (zapis w pliku *Skorowidz.txt)");
			System.out.println("2 : Wy�wietl skorowidz w kolejno�ci alfabetycznej (przegl�d in-order)");
			System.out.println("3 : Wy�wietl skorowidz (przej�cie drzewa wszerz)");	
			System.out.println("4 : Usu� wybrane s�owo (usuwanie w�z�a z drzewa)");	
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
					System.out.println("Prosz� poda� nazw� pliku (na przyk�ad Przyk�ad, Aforyzm, bez ko�c�wki .txt): ");
					String napis = sc.nextLine();					
					System.out.println(napis);
					skorowidz.Utworz(napis);
			
					KomunikatyMenu();
					break;
						
				case 2:							
					System.out.println("Skorowidz wypisany w kolejno�ci alfabetycznej: \n");
					skorowidz.WyswietlSkorowidz();
					
					KomunikatyMenu();
					break;
				
				case 3:						
					System.out.println("Skorowidz wypisany wszerz: \n");
					skorowidz.WypiszWszerz();				
						
					KomunikatyMenu();
					break;
					
				case 4:	
					System.out.println("Prosz� poda� s�owo do usuni�cia: ");
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
				System.out.println("Zako�czono operowanie na tek�cie");
				break;
			}
		}
	}
}

