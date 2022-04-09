package Labki13;

import java.util.Scanner;

	public class Main {
		
		private static Graf graf = new Graf();
		private static ObslugaPliku obsluga = new ObslugaPliku();
		
		public static void KomunikatyMenu() {
			System.out.println("\nMenu :");
			System.out.println("1 : Dodaj wêz³y do grafu");
			System.out.println("2 : Dodaj now¹ krawêdz");
			System.out.println("3 : Wypisz minimalne drzewo rozpinaj¹ce grafu wraz z jego wag¹");	
			System.out.println("4 : Wyœwietl listê s¹siedztwa grafu");	
			System.out.println("5 : Wyœwietl graf (bez duplikatów krawêdzi)");	
			System.out.println("6 : Dodaj wêz³y (lampiony) z pliku");	
			System.out.println("7 : Zapisz graf do pliku");	
			System.out.println("8 : Zrestartuj graf");	
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
					System.out.println("Podaj liczbê wêz³ów do dodania: ");
					
					int liczba = sc.nextInt();		
					
					if(liczba + graf.getVertexCount()<=20) {
						
						if(graf.getVertexCount()==-1) {
							graf.dodajWezel();
						}
						
						System.out.println(graf.dodajWezly(liczba));
					}
					else {
						
						System.out.println("Przekroczono górny limit lampionów: "+graf.getVertexCount()+"+"+liczba+">20");
					}
					
					KomunikatyMenu();
					break;
						
				case 2:	
					
					if(graf.getEdgeCount()+1<=190) {
						
					System.out.println("Podaj wêze³ pocz¹tkowy:");
					int zrodlo = sc.nextInt();
					
					if(zrodlo<1) {
						
						System.out.println("Wêze³ zród³owy musi byæ >=1!"); 
						break;
					}
					
					System.out.println("Podaj wêze³ koñcowy:");
					int cel = sc.nextInt();
					
					System.out.println("Podaj wagê:");
					int waga = sc.nextInt();
					
					if(waga<1) {
						
						System.out.println("Waga po³¹czenia musi byæ >=1!"); 
						break;
					}

					graf.dodajKrawedz(zrodlo, cel, waga);
					}
					else {
						
						System.out.println("Przekroczono górny limit po³¹czeñ: "+graf.getEdgeCount()+"<=190");
					}
					KomunikatyMenu();
					break;
				
				case 3:
					
					graf.AlgorytmKruskala();
			
					KomunikatyMenu();
					break;
					
				case 4:		
					System.out.println("Wyœwietlona lista s¹siedztwa:");
					graf.wyswietlListeSasiedztwa();
		
					KomunikatyMenu();
					break;
					
				case 5:		
					System.out.println("Wyœwietlony graf:");
					graf.wyswietlGraf();
					
					KomunikatyMenu();
					break;
					
				case 6:	
					
					System.out.println("Proszê podaæ nazwê pliku do odczytu (bez koñcówki *.txt):");
					String nazwa = sc.next();
									
					graf = obsluga.Odczyt(nazwa);
					
					KomunikatyMenu();
					break;
					
				case 7:		
					
					obsluga.Zapis(graf);
					
					KomunikatyMenu();
					break;
					
				case 8:		
					graf = new Graf();
					System.out.println("Zrestartowano graf!");
					
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
				System.out.println("Zakoñczono operowanie na grafie!");
				break;
			}
		}
	}
}

