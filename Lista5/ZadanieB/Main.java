package Zadanie5b;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static Baza baza;
	
	public static void KomunikatyMenu() {
		System.out.println("\nMenu :");
		System.out.println("1 : Utworzenie nowej bazy danych");
		System.out.println("2 : Odczyt bazy z pliku");
		System.out.println("3 : Wyœwietlenie wszystkich rekordów");
		System.out.println("4 : Wyœwietlenie danych jednego pracownika");
		System.out.println("5 : Dopisanie nowego pracownika ");
		System.out.println("6 : Usuniêcie pracownika z bazy");
		System.out.println("7 : Aktualizowanie danych pracownika");		
		System.out.println("8 : Obliczanie œredniej pensji w firmie");		
		System.out.println("9 : Obliczanie ilu pracowników zarabia poni¿ej œredniej");		
		System.out.println("10 : Zapis bazy do pliku");		
		System.out.println("11 : Dodaj 5 pracownikow");	
		System.out.println("12 : Symulacja parkingu");	
		System.out.println("0 : Wyjœcie");
	}
	
	
	public static void KomunikatyMenuParking() {
		System.out.println("\nMenu :");
		System.out.println("1 : Wyswietl stan parkingu (od do³u stosu do góry)");	
		System.out.println("2 : Zglos chec wyjazdu i powiadom kierowcow (s¹ mili, natychmiast odjad¹, a nastêpnie wjad¹ z powrotem)");
		System.out.println("3 : Na parking wjezdza pracownik z bazy");
		System.out.println("4 : Na parking wjezdzaja wszyscy pracownicy z bazy w kolejnosci od 0 do ostatniego indeksu");
		System.out.println("0 : Wyjœcie");
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Pracownik pracownik1 = new Pracownik(16453456899L, "Kowalski", "Jan", "05/04/1996", "ksiêgowy", 4250, 5);
		Pracownik pracownik2 = new Pracownik(32341678900L, "Mlynarski", "Kazimierz", "22/12/2000", "goniec", 3500, 15);
		Pracownik pracownik3 = new Pracownik(23456784566L, "Pieprz", "Anita", "12/07/1972", "dyrektor", 12384, 25);
		Pracownik pracownik4 = new Pracownik(42454345678L, "Kowadlo", "Chojnacy", "17/02/1984", "sekretarz", 4500, 18);
		Pracownik pracownik5 = new Pracownik(88767854321L, "Maciag", "Magdalena", "23/07/1993", "kierowca", 3400, 13);
		
		int Opcja;
		Scanner sc = new Scanner(System.in);
		KomunikatyMenu();
		while(sc.hasNext()) {
			Opcja = sc.nextInt();
			
			if(Opcja!=0) {
				switch(Opcja) {
				case 1:	
						baza = new Baza();
						System.out.println("Utworzono now¹ bazê!");
						KomunikatyMenu();
					break;
						
				case 2:	
					if(baza!=null) {
						baza.Odczyt();
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 3:	
					if(baza!=null) {
					baza.WyswietlBaze();
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
				break;
				
				case 4:	
					if(baza!=null) {
						System.out.println("Którego pracownika wyswietlic?");
						int numer = sc.nextInt();
						if(numer>=0 && numer<baza.getLista().size()) {
							baza.WyswietlPracownika(numer);
						}else {
							System.out.println("Nie ma pracownika o podanym indeksie!");
						}
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					
					KomunikatyMenu();
				break;
				
				case 5:
					if(baza!=null) {
					System.out.println("Podaj PESEL:");
					long pesel = sc.nextLong();
					System.out.println("Podaj Nazwisko:");
					String nazwisko = sc.next();
					System.out.println("Podaj Imie:");
					String imie = sc.next();
					System.out.println("Podaj Data_urodzenia:");
					String data_urodzenia = sc.next();
					System.out.println("Podaj Stanowisko:");
					String stanowisko = sc.next();
					System.out.println("Podaj Pensja:");
					int pensja = sc.nextInt();
					System.out.println("Podaj Sta¿:");
					int sta¿ = sc.nextInt();
					baza.Dodaj(new Pracownik(pesel, nazwisko, imie, data_urodzenia, stanowisko, pensja, sta¿));
					System.out.println("Dodano pomyœlnie!");
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 6:	
					if(baza!=null) {
						System.out.println("Podaj index:");
						int index = sc.nextInt();
						if(index>=0 && index<baza.getLista().size()) {
						baza.Usun(index);
						}else {
							System.out.println("Nie ma pracownika o podanym indeksie!");
						}
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 7:
					if(baza!=null) {
						System.out.println("Którego pracownika aktualizowac?");
						int numer = sc.nextInt();
						if(numer>=0 && numer<baza.getLista().size()) {
						Pracownik pracownik = baza.getLista().get(numer);
						
						System.out.println("PESEL: 1\nNazwisko: 2\nImie: 3\nData_urodzenia: 4\nStanowisko: 5\nPensja: 6\nSta¿: 7");
						int wybor = sc.nextInt();						
						
						switch(wybor) {
						case 1:	
							baza.getLista().remove(pracownik);
							System.out.println("Podaj nowy pesel:");
							pracownik.setPESEL(sc.nextLong());
							baza.Dodaj(pracownik);
							break;
							
						case 2:					
							System.out.println("Podaj nowe nazwisko:");
							pracownik.setNazwisko(sc.next());
							break;
							
						case 3:					
							System.out.println("Podaj nowe imie:");
							pracownik.setImie(sc.next());
							break;
							
						case 4:					
							System.out.println("Podaj nowa date urodzenia:");
							pracownik.setData_urodzenia(sc.next());
							break;
							
						case 5:					
							System.out.println("Podaj nowe stanowisko:");
							pracownik.setStanowisko(sc.next());
							break;
							
						case 6:					
							System.out.println("Podaj nowa pensje:");
							pracownik.setPensja(sc.nextDouble());
							pracownik.aktualizujPremia();
							break;
							
						case 7:					
							System.out.println("Podaj nowy staz:");
							pracownik.setSta¿(sc.nextDouble());
							pracownik.aktualizujPremia();
							break;
							
						default:
						{
							System.out.println("Brak wyboru");
							break;
						}
						}
						}else {
							System.out.println("Nie ma pracownika o podanym indeksie!");
						}
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 8:
					if(baza!=null) {
						System.out.println("Œrednia pensja w firmie: "+baza.ŒredniaPensja());						
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 9:	
					if(baza!=null) {
						System.out.println("Ponizej sredniej pensji w firmie zarabia: "+baza.IluPonizejSredniej()+" pracownikow.");
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 10:
					if(baza!=null) {
						baza.Zapis();
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 11:
					if(baza!=null) {
						baza.Dodaj(pracownik1);
						baza.Dodaj(pracownik2);
						baza.Dodaj(pracownik3);
						baza.Dodaj(pracownik4);
						baza.Dodaj(pracownik5);
					}else {
						System.out.println("Nie utworzono bazy!");
					}
					KomunikatyMenu();
					break;
					
				case 12:
					//submenu
					Parking parking = new Parking();
					int Opcja2;
					Scanner sc2 = new Scanner(System.in);
					KomunikatyMenuParking();
					while(sc2.hasNext()) {
						Opcja2 = sc2.nextInt();
						
						if(Opcja2!=0) {
							switch(Opcja2) {
							case 1:	
									parking.Wyswietl(parking.getStos());									
									KomunikatyMenuParking();
								break;
								
							case 2:	
								System.out.println("Podaj indeks w stosie pracownika, ktory chce wyjechac (0-szczyt stosu)");
								parking.Wyjazd(sc.nextInt());								
								KomunikatyMenuParking();
								break;
								
							case 3:	
								if(baza!=null) {
								System.out.println("Indeks pracownika z bazy: ");
								int index = sc2.nextInt();
								parking.Wjazd(baza.getLista().get(index));	
								}else {
									System.out.println("Nie utworzono bazy!");
								}
								KomunikatyMenuParking();
								break;
								
							case 4:	
								if(baza!=null) {								
									for(Pracownik x: baza.getLista()) {
									parking.Wjazd(x);
									}
									}else {
										System.out.println("Nie utworzono bazy!");
									}																
								KomunikatyMenuParking();
								break;
								
							default:
							{
								System.out.println("Brak wyboru");
								KomunikatyMenuParking();
								break;
							}
								
							}
						}
						else {
							System.out.println("Zakoñczono operowanie na parkingu");
							break;
						}
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
				System.out.println("Zakoñczono operowanie na bazie");
				break;
			}
		}

	}

}
