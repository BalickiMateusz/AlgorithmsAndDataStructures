package Zadanie;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static ListaKart ListaKart;
	
	public static void KomunikatyMenu() {
		System.out.println("\nMenu :");
		System.out.println("1 : Utworzenie listy(karty mog¹ siê powtarzaæ)");
		System.out.println("2 : Wyœwietlanie listy");
		System.out.println("3 : Wyœwietlanie liczby elementów listy");
		System.out.println("4 : Wyœwietlanie kart o podanej wartoœci");
		System.out.println("5 : Wyœwietlanie kart o podanym kolorze");
		System.out.println("6 : Usuwanie kart powtarzaj¹cych siê(do testów usuwania nale¿y na pocz¹tek listy dodaæ trzy karty As kier)");
		System.out.println("7 : Dodaj na pocz¹tek listy trzy karty As kier");		
		System.out.println("0 : Wyjœcie");
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
					System.out.println("Podaj wartoœæ: ");
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
				System.out.println("Zakoñczono operowanie na liœcie");
				break;
			}
		}

	}

}
