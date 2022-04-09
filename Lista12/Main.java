package Lab12;

import java.util.HashMap;
import java.util.Scanner;

	public class Main {
		
		private static Graf graf = new Graf();
		private static HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		private static Integer j = 0;
		
		public static void KomunikatyMenu() {
			System.out.println("\nMenu :");
			System.out.println("1 : Dodaj miasta do grafu");
			System.out.println("2 : Dodaj nowe po³¹czenie");
			System.out.println("3 : Wypisz wszystkie miasta osi¹galne z podanego wraz z najkrótszymi do nich drogami");	
			System.out.println("4 : Przejdz graf w g³¹b (DFS)");	
			System.out.println("5 : Wyœwietl graf");	
			System.out.println("6 : Dodaj miasta z treœci zadania");	
			System.out.println("7 : Zrestartuj graf");	
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
					System.out.println("Podaj liczbê miast do dodania: ");
					
					int liczba = sc.nextInt();
					
					for(int i=0; i<liczba; i++) {
						
						System.out.println("Podaj nazwê miasta: "+i+":");
						mapa.put(sc.next(), j++);
					}
					
					graf.dodajWezly(mapa);	
					
					KomunikatyMenu();
					break;
						
				case 2:	
					System.out.println("Podaj miasto pocz¹tkowe:");
					String zrodlo = sc.next();
					
					System.out.println("Podaj miasto koñcowe:");
					String cel = sc.next();
					
					System.out.println("Podaj odleg³oœæ:");
					int waga = sc.nextInt();
					
					graf.dodajKrawedz(zrodlo, cel, waga);
					
					KomunikatyMenu();
					break;
				
				case 3:
					System.out.println("Podaj pocz¹tkowe miasto:");
					graf.AlgorytmDijkstry(sc.next());				
					KomunikatyMenu();
					break;
					
				case 4:		
					System.out.println("Podaj pocz¹tkowe miasto:");
					graf.DFS(sc.next());
					
					KomunikatyMenu();
					break;
					
				case 5:		
					System.out.println("Wyœwietlony graf:");
					graf.wyswietlGraf();
					
					KomunikatyMenu();
					break;
					
				case 6:	
					mapa.put("Wroc³aw",j++);
					mapa.put("O³awa",j++);
					mapa.put("Brzeg",j++);
					mapa.put("Nysa",j++);
					mapa.put("Opole",j++);
					
					graf.dodajWezly(mapa);	
					
					graf.dodajKrawedz("Wroc³aw", "O³awa", 10);
					graf.dodajKrawedz("Wroc³aw", "Nysa", 30);
					graf.dodajKrawedz("Wroc³aw", "Opole", 100);
					graf.dodajKrawedz("O³awa", "Brzeg", 50);
					graf.dodajKrawedz("Brzeg", "Opole", 10);
					graf.dodajKrawedz("Nysa", "Brzeg", 20);
					graf.dodajKrawedz("Nysa", "Opole", 60);
				
					KomunikatyMenu();
					break;
					
				case 7:		
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

