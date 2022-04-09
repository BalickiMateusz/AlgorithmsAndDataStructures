package Lab9;

import java.util.Scanner;

public class Main {

	public static String napis="";	
	public static ExpressionTree drzewo = new ExpressionTree();
	
	public static void KomunikatyMenu() {
		System.out.println("\nMenu :");
		System.out.println("1 : Wczytaj wyra�enie np. (10+2)*(5+15) - dozwolone operatory to (+,-, *, /, %), bez spacji");
		System.out.println("2 : Zamie� na ONP");
		System.out.println("3 : Tworzenie drzewa wyra�enia, w�z�y zawieraj� albo liczby ca�kowite albo operatory (+,-, *, /, %)");
		System.out.println("4 : Obliczanie wyra�enia arytmetycznego zapisanego w drzewie binarnym");
		System.out.println("5 : Wy�wietlanie wyra�enia w postaci infiksowej (z nawiasami) ");
		System.out.println("6 : Wy�wietlanie wyra�enia w postaci postfiksowej (w postaci beznawiasowej, ONP)");
		System.out.println("7 : Obliczanie liczby li�c");		
		System.out.println("8 : Obliczanie liczby w�z��w");		
		System.out.println("9 : Obliczanie wysoko�ci drzewa");		
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
					System.out.println("Prosz� poda� wyra�enie: ");
					napis = sc.nextLine();
					KomunikatyMenu();
					break;
						
				case 2:	
					ONP onp = new ONP();
					napis = onp.Konwetruj(napis);
					System.out.println("Wyrazenie w postaci ONP:");
					System.out.println(napis);
					KomunikatyMenu();
					break;
				
				case 3:						
					drzewo.wypelnijDrzewo(napis);
					KomunikatyMenu();
					break;
				
				case 4:
					System.out.println("Obliczone wyra�enie arytmetyczne z drzewa:");
					drzewo.Oblicz();
					KomunikatyMenu();
					break;
					
				case 5:	
					System.out.println("Wyrazenie z nawiasami (inorder):");
					drzewo.inOrder();
					KomunikatyMenu();
					break;
					
				case 6:
					System.out.println("Wyrazenie w postaci beznawiasowej (ONP):");
					drzewo.postOrder();
					KomunikatyMenu();
					break;
					
				case 7:
					System.out.println("Liczba lisci drzewa:");
					drzewo.liczbaLisci();
					KomunikatyMenu();
					break;
					
				case 8:	
					System.out.println("Liczba wezlow drzewa:");
					drzewo.liczbaWezlow();
					KomunikatyMenu();
					break;
					
				case 9:	
					System.out.println("Wysokosc drzewa:");
					drzewo.Wysokosc();
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
				System.out.println("Zako�czono operowanie na wyra�eniach");
				break;
			}
		}

	}
}
