package Zadanie1b;

public class PracownikGodzinowy extends Pracownik {
	
	private int liczba_godz;
	private double stawka;
	
	public PracownikGodzinowy() {
		super();
		liczba_godz = 0;
		stawka = 0;
	}
	
	public PracownikGodzinowy(String nazwisko, String imie, long pesel, String stanowisko, int staz, int liczba_godz, double stawka) {
		super(nazwisko, imie, pesel, stanowisko, staz);
		this.liczba_godz = liczba_godz;
		this.stawka = stawka;
	}
	
	public int getLiczba_godz() {
		return liczba_godz;
	}
	
	public double getStawka() {
		return stawka;
	}
	public void setLiczba_godz(int liczba_godz) {
		this.liczba_godz = liczba_godz;
	}
	
	public void setStawka(double stawka) {
		this.stawka = stawka;
	}
	
	@Override
	public String toString() {
		String napis = String.format("%5d %s %5f %s %6s%s","|",liczba_godz,"|",stawka,"|",String.valueOf(Pensja()),"|");
		return napis;
	}
	
	@Override
	public double Pensja() {
		return stawka*liczba_godz;
	}
	
}
