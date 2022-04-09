package Zadanie1b;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	private static Pracownik[] tab;
	private static int ilosc;
	
	public static void KomunikatyMenu() {
		System.out.println("\nMenu :");
		System.out.println("1 : Dodaj pracownikow do tablicy czytajac dane z klawiatury");
		System.out.println("2 : Wyœwietl pracownikow zapisanych w tablicy w tabeli");
		System.out.println("3 : Eksportuj pracownikow z tablicy do pliku");
		System.out.println("4 : Dodaj pracownikow do tablicy czytajac dane z pliku");	
		System.out.println("5 : Wyœwietl pracownikow zapisanych w tablicy (sam iterator)");
		System.out.println("0 : Wyjœcie");
	}
	
	public static void Dodawanie(int ilosc, Scanner sc) {
		for (int i=0;i<ilosc;i++) {
		System.out.println("Dodawanie pracownika numer: "+i);	
		System.out.println("Podaj nazwisko:");
		String nazwisko = sc.next();
		
		System.out.println("Podaj imie:");
		String imie = sc.next();
		
		System.out.println("Podaj pesel:");
		long pesel = sc.nextLong();
		
		System.out.println("Podaj stanowisko:");
		String stanowisko = sc.next();
		
		System.out.println("Podaj staz:");
		int staz = sc.nextInt();
		
		System.out.println("Wybierz rodzaj pracownika:");
		System.out.println("Wpisz 1 - pracownik etatowy");
		System.out.println("Wpisz 2 - pracownik godzinowy");
		
		int rodzaj = sc.nextInt();
			if(rodzaj == 1) {
				
				System.out.println("Podaj etat(0,75, 0,5, 1):");
				double etat = sc.nextDouble();
				System.out.println("Podaj stawkê:");
				double stawka = sc.nextDouble();
				
				tab[i] = new PracownikEtatowy(nazwisko, imie, pesel, stanowisko, staz, etat, stawka);
			}
			else if(rodzaj == 2) {
				
				System.out.println("Podaj liczbê godzin:");
				int liczba_godz = sc.nextInt();
				System.out.println("Podaj stawkê:");
				double stawka = sc.nextDouble();
				
				tab[i] = new PracownikGodzinowy(nazwisko, imie, pesel, stanowisko, staz, liczba_godz, stawka);
			}else
			{
				System.out.println("Brak wyboru");
			}
		}
	}
	
	public static void show() {
		if(tab!=null) {
		Iterator<Pracownik> iter=new IteratorTab<Pracownik>(tab);
		String napis1=String.format("%s %-13s %s %-10s %s %-11s %s %-10s %s %-5s%s %-6s%s","|","Nazwisko","|", "Imiê","|", "Pesel","|", "Stanowisko","|", "Sta¿","|","Pensja","|");
		String napis = String.format("%0"+napis1.length()+"d%s",0,"").replace("0", "-");
		System.out.println(napis);
		System.out.println(napis1);
		System.out.println(napis);
		while(iter.hasNext()) {
		iter.next().wyswietl();;
		}
		}else {
			System.out.println("Tablica jest pusta!");
		}
	}
	
	public static void showIter() {
		if(tab!=null) {
			Iterator<Pracownik> iter=new IteratorTab<Pracownik>(tab);
			while(iter.hasNext()) {
			Pracownik a= iter.next();
			a.wyswietl();
			System.out.print(a.toString());
			}
			}else {
				System.out.println("Tablica jest pusta!");
			}
	}
	
	public static void zapisz() {
		
		try (ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream("PlikPracownicy.ser"))) 
		{		zapis.write(tab.length);
			for(int i=0; i<tab.length;i++) {
				zapis.writeObject(tab[i]);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
	
	public static void odczytaj() {
		
		try (ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream("PlikPracownicy.ser"))) {
				int dlugosc = odczyt.read();
				tab = new Pracownik[dlugosc];
			for(int i=0; i<tab.length;i++) {
				tab[i] = (Pracownik) odczyt.readObject();
			}	
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		int Opcja;
		Scanner sc = new Scanner(System.in);
		KomunikatyMenu();
		while(sc.hasNext()) {
			Opcja = sc.nextInt();
			
			if(Opcja!=0) {
				switch(Opcja) {
				case 1:	
						System.out.println("Podaj liczbê pracowników do dodania:");
						ilosc = sc.nextInt();
						tab = new Pracownik[ilosc];
						Dodawanie(ilosc, sc);
						KomunikatyMenu();
					break;
						
				case 2:
						show();
						KomunikatyMenu();
					break;
					
				case 3:
					zapisz();
					System.out.println("Zapisano pomyœlnie!");
					KomunikatyMenu();
				break;
				
				case 4:
					odczytaj();
					KomunikatyMenu();
				break;
				
				case 5:
					showIter();
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
				System.out.println("Zakoñczono dodawanie");
				break;
			}
	}
	}
}
