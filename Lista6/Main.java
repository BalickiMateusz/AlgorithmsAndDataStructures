package Lab6;

public class Main {

	public static void main(String[] args) {
		
		Zamowienie zamowienie1 = new Zamowienie("Para Butów", 20, 150);
		Zamowienie zamowienie2 = new Zamowienie("Banan", 13, 2);
		Zamowienie zamowienie3 = new Zamowienie("D³ugopis", 80, 1.5);
		Zamowienie zamowienie4 = new Zamowienie("Jab³ko", 40, 0.8);
		Zamowienie zamowienie5 = new Zamowienie("S³uchawki", 32, 250);
		Zamowienie zamowienie6 = new Zamowienie("Zeszyt", 10, 12);
		Zamowienie zamowienie7 = new Zamowienie("Notes", 15, 15);
		Zamowienie zamowienie8 = new Zamowienie("Marker", 17, 5);
		Zamowienie zamowienie9 = new Zamowienie("Zas³ony", 23, 149.99);
		Zamowienie zamowienie10 = new Zamowienie("Tablica", 48, 399.99);
		Zamowienie zamowienie11 = new Zamowienie("Monitor", 92, 1499.99);
		Zamowienie zamowienie12 = new Zamowienie("Laptop", 24, 3499.99);
		Zamowienie zamowienie13 = new Zamowienie("Koszyk", 41, 20);
		Zamowienie zamowienie14 = new Zamowienie("Widelec", 57, 15.5);
		Zamowienie zamowienie15 = new Zamowienie("Gitara", 76, 1300);
		Zamowienie zamowienie16 = new Zamowienie("Poduszka", 45, 25);
		Zamowienie zamowienie17 = new Zamowienie("Poœciel", 76, 140);
		Zamowienie zamowienie18 = new Zamowienie("Biurko", 32, 650);
		Zamowienie zamowienie19 = new Zamowienie("Materac", 87, 1249.5);
		Zamowienie zamowienie20 = new Zamowienie("O³ówek", 12, 0.75);
		
		Klient klient1 = new Klient("Jan");
		klient1.dodajZamowienie(zamowienie1);
		klient1.dodajZamowienie(zamowienie2);
		klient1.dodajZamowienie(zamowienie3);
		
		Klient klient2 = new Klient("Stefan");		
		klient2.dodajZamowienie(zamowienie4);
		klient2.dodajZamowienie(zamowienie5);
		
		Klient klient3 = new Klient("Anna");		
		klient3.dodajZamowienie(zamowienie6);
		klient3.dodajZamowienie(zamowienie7);
		klient3.dodajZamowienie(zamowienie8);
		klient3.dodajZamowienie(zamowienie9);
		
		Klient klient4 = new Klient("Eliza");
		klient4.dodajZamowienie(zamowienie10);
		klient4.dodajZamowienie(zamowienie11);
		klient4.dodajZamowienie(zamowienie12);
		klient4.dodajZamowienie(zamowienie13);
		klient4.dodajZamowienie(zamowienie14);
		klient4.dodajZamowienie(zamowienie15);
		
		Klient klient5 = new Klient("Adam");	
		klient5.dodajZamowienie(zamowienie16);
		klient5.dodajZamowienie(zamowienie17);
		klient5.dodajZamowienie(zamowienie18);
		klient5.dodajZamowienie(zamowienie19);
		klient5.dodajZamowienie(zamowienie20);
		
		Magazyn magazyn = new Magazyn();		
		magazyn.dodajKlienta(klient1);
		magazyn.dodajKlienta(klient2);
		magazyn.dodajKlienta(klient3);
		magazyn.dodajKlienta(klient4);
		magazyn.dodajKlienta(klient5);
		
		//System.out.println(magazyn.RealizujZamowieniaKlienta(klient1));
		System.out.println("Suma kwot: "+magazyn.RealizujWszystkieZamowienia());
	}
}