package Zadanie1b;

import java.io.Serializable;

public abstract class Pracownik implements Serializable {

	protected String nazwisko;
	protected String imie;
	protected long pesel;
	protected String stanowisko;
	protected int staz;
	
	public Pracownik() {
		nazwisko = "";
		imie = "";
		pesel = 0;
		stanowisko = "";
		staz = 0;
	}
	
	public Pracownik(String nazwisko, String imie, long pesel, String stanowisko, int staz) {
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.pesel = pesel;
		this.stanowisko = stanowisko;
		this.staz = staz;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public long getPesel() {
		return pesel;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public int getstaz() {
		return staz;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public void setPesel(long pesel) {
		this.pesel = pesel;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public void setstaz(int staz) {
		this.staz = staz;
	}
	
	public void wyswietl(){
		System.out.printf("%s %-13s %s %-10s %s %011d %s %-10s %s %5d%s","|",nazwisko,"|", imie,"|", pesel,"|", stanowisko,"|", staz,"|");
	}
	
	@Override
	public String toString() {
		String napis = String.format("%s %-13s %s %-10s %s %-11s %s %-10s %s %-5s%s %-6s%s","|","Nazwisko","|", "Imiê","|", "Pesel","|", "Stanowisko","|", "Sta¿","|","Pensja","|");
		return napis;
	}

	abstract public double Pensja();
}
