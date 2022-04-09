package Zadanie;

import java.util.Random;

public class Karta {
	
	private int Wartosc;
	private int Kolor;
	
	public Karta() {
		Random rd = new Random();
		Wartosc = rd.nextInt(14);
		Kolor = rd.nextInt(4);
	}
	
	public Karta(int wartosc, int kolor) {
		this.Wartosc = wartosc;
		this.Kolor = kolor;
	}

	public int getWartosc() {
		return Wartosc;
	}

	public int getKolor() {
		return Kolor;
	}

	public void setWartosc(int wartosc) {
		Wartosc = wartosc;
	}

	public void setKolor(int kolor) {
		Kolor = kolor;
	}

	@Override
	public String toString() {
		return "\nKarta [Wartosc=" + Wartosc + ", Kolor=" + Kolor + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Karta karta2 = (Karta) obj;
        
        if (this.Wartosc != karta2.Wartosc) {
            return false;
        }

        if (this.Kolor != karta2.Kolor) {
            return false;
        }

        return true;
    }
	
	
}
