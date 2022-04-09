package Zadanie;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static ListaKart ListaKart;
	
	public static void KomunikatyMenu() {
		System.out.println("\nMenu :");
		System.out.println("1 : Utworzenie listy(karty mog� si� powtarza�)");
		System.out.println("2 : Wy�wietlanie listy");
		System.out.println("3 : Wy�wietlanie liczby element�w listy");
		System.out.println("4 : Wy�wietlanie kart o podanej warto�ci");
		System.out.println("5 : Wy�wietlanie kart o podanym kolorze");
		System.out.println("6 : Usuwanie kart powtarzaj�cych si�(do test�w usuwania nale�y na pocz�tek listy doda� trzy karty As kier)");
		System.out.println("7 : Dodaj na pocz�tek listy trzy karty As kier");		
		System.out.println("0 : Wyj�cie");
	}
	
	public static void main(String[] args) {
		int Opcja;
		Scanner sc = new Scanner(System.in);
		KomunikatyMenu();
		while(sc.hasNext()) {
			Opcja = sc.nextInt();
			
			if(Opcja!=0) {
				switch(Opcja) {
				case 1:	
						 ListaKart = new ListaKart();
						 ListaKart.Wypelnij();
						KomunikatyMenu();
					break;
						
				case 2:
					if(ListaKart!=null) {
						ListaKart.Wyswietl();
					}else{
						System.out.println("Nie utworzono listy!");
					}
						KomunikatyMenu();
					break;
					
				case 3:
					if(ListaKart!=null) {
						ListaKart.Licznosc();
					}else{
						System.out.println("Nie utworzono listy!");
					}
					KomunikatyMenu();
				break;
				
				case 4:
					System.out.println("Podaj warto��: ");
					int v = sc.nextInt();
					
					if(ListaKart!=null) {
						ListaKart.ShowByValue(v);
					}else{
						System.out.println("Nie utworzono listy!");
					}
					KomunikatyMenu();
				break;
				
				case 5:
					System.out.println("Podaj kolor: ");
					int k = sc.nextInt();
					
					if(ListaKart!=null) {
						ListaKart.ShowByColour(k);
					}else{
						System.out.println("Nie utworzono listy!");
					}
					KomunikatyMenu();
					break;
					
				case 6:
					if(ListaKart!=null) {
						ListaKart.setLista(ListaKart.DeleteDuplicates());
					}else{
						System.out.println("Nie utworzono listy!");
					}
					KomunikatyMenu();
					break;
					
				case 7:
					if(ListaKart!=null) {
						ListaKart.DodajAsy();
					}else{
						System.out.println("Nie utworzono listy!");
					}
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
				System.out.println("Zako�czono operowanie na li�cie");
				break;
			}
		}

	}

}
