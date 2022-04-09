package Labki13;

import java.util.Scanner;

	public class Main {
		
		private static Graf graf = new Graf();
		private static ObslugaPliku obsluga = new ObslugaPliku();
		
		public static void KomunikatyMenu() {
			System.out.println("\nMenu :");
			System.out.println("1 : Dodaj w�z�y do grafu");
			System.out.println("2 : Dodaj now� kraw�dz");
			System.out.println("3 : Wypisz minimalne drzewo rozpinaj�ce grafu wraz z jego wag�");	
			System.out.println("4 : Wy�wietl list� s�siedztwa grafu");	
			System.out.println("5 : Wy�wietl graf (bez duplikat�w kraw�dzi)");	
			System.out.println("6 : Dodaj w�z�y (lampiony) z pliku");	
			System.out.println("7 : Zapisz graf do pliku");	
			System.out.println("8 : Zrestartuj graf");	
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
					System.out.println("Podaj liczb� w�z��w do dodania: ");
					
					int liczba = sc.nextInt();		
					
					if(liczba + graf.getVertexCount()<=20) {
						
						if(graf.getVertexCount()==-1) {
							graf.dodajWezel();
						}
						
						System.out.println(graf.dodajWezly(liczba));
					}
					else {
						
						System.out.println("Przekroczono g�rny limit lampion�w: "+graf.getVertexCount()+"+"+liczba+">20");
					}
					
					KomunikatyMenu();
					break;
						
				case 2:	
					
					if(graf.getEdgeCount()+1<=190) {
						
					System.out.println("Podaj w�ze� pocz�tkowy:");
					int zrodlo = sc.nextInt();
					
					if(zrodlo<1) {
						
						System.out.println("W�ze� zr�d�owy musi by� >=1!"); 
						break;
					}
					
					System.out.println("Podaj w�ze� ko�cowy:");
					int cel = sc.nextInt();
					
					System.out.println("Podaj wag�:");
					int waga = sc.nextInt();
					
					if(waga<1) {
						
						System.out.println("Waga po��czenia musi by� >=1!"); 
						break;
					}

					graf.dodajKrawedz(zrodlo, cel, waga);
					}
					else {
						
						System.out.println("Przekroczono g�rny limit po��cze�: "+graf.getEdgeCount()+"<=190");
					}
					KomunikatyMenu();
					break;
				
				case 3:
					
					graf.AlgorytmKruskala();
			
					KomunikatyMenu();
					break;
					
				case 4:		
					System.out.println("Wy�wietlona lista s�siedztwa:");
					graf.wyswietlListeSasiedztwa();
		
					KomunikatyMenu();
					break;
					
				case 5:		
					System.out.println("Wy�wietlony graf:");
					graf.wyswietlGraf();
					
					KomunikatyMenu();
					break;
					
				case 6:	
					
					System.out.println("Prosz� poda� nazw� pliku do odczytu (bez ko�c�wki *.txt):");
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
				System.out.println("Zako�czono operowanie na grafie!");
				break;
			}
		}
	}
}

