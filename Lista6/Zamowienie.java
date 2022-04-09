package Lab6;

public class Zamowienie {
	
	private String nazwaTowaru;
	private int liczbaSztuk;
	private double cenaJednostkowa;
	
	public Zamowienie(String nazwaTowaru, int liczbaSztuk, double cenaJednostkowa) {
		this.nazwaTowaru = nazwaTowaru;
		this.liczbaSztuk = liczbaSztuk;
		this.cenaJednostkowa = cenaJednostkowa;
	}

	public String getNazwaTowaru() {
		return nazwaTowaru;
	}

	public int getLiczbaSztuk() {
		return liczbaSztuk;
	}

	public double getCenaJednostkowa() {
		return cenaJednostkowa;
	}

	public void setNazwaTowaru(String nazwaTowaru) {
		this.nazwaTowaru = nazwaTowaru;
	}

	public void setLiczbaSztuk(int liczbaSztuk) {
		this.liczbaSztuk = liczbaSztuk;
	}

	public void setCenaJednostkowa(double cenaJednostkowa) {
		this.cenaJednostkowa = cenaJednostkowa;
	}

	@Override
	public String toString() {
		return "Zamówienie [nazwaTowaru=" + nazwaTowaru + ", liczbaSztuk=" + liczbaSztuk + ", cenaJednostkowa="
				+ cenaJednostkowa + "]";
	}	
}
