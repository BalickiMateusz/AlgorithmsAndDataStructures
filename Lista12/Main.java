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
			System.out.println("2 : Dodaj nowe po��czenie");
			System.out.println("3 : Wypisz wszystkie miasta osi�galne z podanego wraz z najkr�tszymi do nich drogami");	
			System.out.println("4 : Przejdz graf w g��b (DFS)");	
			System.out.println("5 : Wy�wietl graf");	
			System.out.println("6 : Dodaj miasta z tre�ci zadania");	
			System.out.println("7 : Zrestartuj graf");	
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
					System.out.println("Podaj liczb� miast do dodania: ");
					
					int liczba = sc.nextInt();
					
					for(int i=0; i<liczba; i++) {
						
						System.out.println("Podaj nazw� miasta: "+i+":");
						mapa.put(sc.next(), j++);
					}
					
					graf.dodajWezly(mapa);	
					
					KomunikatyMenu();
					break;
						
				case 2:	
					System.out.println("Podaj miasto pocz�tkowe:");
					String zrodlo = sc.next();
					
					System.out.println("Podaj miasto ko�cowe:");
					String cel = sc.next();
					
					System.out.println("Podaj odleg�o��:");
					int waga = sc.nextInt();
					
					graf.dodajKrawedz(zrodlo, cel, waga);
					
					KomunikatyMenu();
					break;
				
				case 3:
					System.out.println("Podaj pocz�tkowe miasto:");
					graf.AlgorytmDijkstry(sc.next());				
					KomunikatyMenu();
					break;
					
				case 4:		
					System.out.println("Podaj pocz�tkowe miasto:");
					graf.DFS(sc.next());
					
					KomunikatyMenu();
					break;
					
				case 5:		
					System.out.println("Wy�wietlony graf:");
					graf.wyswietlGraf();
					
					KomunikatyMenu();
					break;
					
				case 6:	
					mapa.put("Wroc�aw",j++);
					mapa.put("O�awa",j++);
					mapa.put("Brzeg",j++);
					mapa.put("Nysa",j++);
					mapa.put("Opole",j++);
					
					graf.dodajWezly(mapa);	
					
					graf.dodajKrawedz("Wroc�aw", "O�awa", 10);
					graf.dodajKrawedz("Wroc�aw", "Nysa", 30);
					graf.dodajKrawedz("Wroc�aw", "Opole", 100);
					graf.dodajKrawedz("O�awa", "Brzeg", 50);
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
				System.out.println("Zako�czono operowanie na grafie!");
				break;
			}
		}
	}
}

