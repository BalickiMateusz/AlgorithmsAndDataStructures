package Lab9;

import java.util.Scanner;

public class Main {

	public static String napis="";	
	public static ExpressionTree drzewo = new ExpressionTree();
	
	public static void KomunikatyMenu() {
		System.out.println("\nMenu :");
		System.out.println("1 : Wczytaj wyra¿enie np. (10+2)*(5+15) - dozwolone operatory to (+,-, *, /, %), bez spacji");
		System.out.println("2 : Zamieñ na ONP");
		System.out.println("3 : Tworzenie drzewa wyra¿enia, wêz³y zawieraj¹ albo liczby ca³kowite albo operatory (+,-, *, /, %)");
		System.out.println("4 : Obliczanie wyra¿enia arytmetycznego zapisanego w drzewie binarnym");
		System.out.println("5 : Wyœwietlanie wyra¿enia w postaci infiksowej (z nawiasami) ");
		System.out.println("6 : Wyœwietlanie wyra¿enia w postaci postfiksowej (w postaci beznawiasowej, ONP)");
		System.out.println("7 : Obliczanie liczby liœc");		
		System.out.println("8 : Obliczanie liczby wêz³ów");		
		System.out.println("9 : Obliczanie wysokoœci drzewa");		
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
					System.out.println("Proszê podaæ wyra¿enie: ");
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
					System.out.println("Obliczone wyra¿enie arytmetyczne z drzewa:");
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
				System.out.println("Zakoñczono operowanie na wyra¿eniach");
				break;
			}
		}

	}
}
