package Zadanie1b;

import java.util.Scanner;

public class PracownikEtatowy extends Pracownik {

	private double etat;
	private double stawka;
	
	public PracownikEtatowy() {
		super();
		etat = 1;
		stawka = 0;
	}
	public PracownikEtatowy(String nazwisko, String imie, long pesel, String stanowisko, int staz, double etat, double stawka) {
		super(nazwisko, imie, pesel, stanowisko, staz);
		this.stawka = stawka;
		if(etat==0.75||etat==0.5||etat==1)
		{
		this.etat = etat;	
		}else {
			while(!(etat==0.75||etat==0.5||etat==1))
			{
			System.out.println("Podano niew³aœciwy etat! Dozwolone wartoœci to: 0.75 0.5 1. Podaj w³aœciwy etat:");
			Scanner sc = new Scanner(System.in);
			etat = sc.nextDouble();
			}
			this.etat = etat;
		}
	}
	public double getEtat() {
		return etat;
	}
	public double getStawka() {
		return stawka;
	}
	public void setEtat(double etat) {
		this.etat = etat;
	}
	public void setStawka(double stawka) {
		this.stawka = stawka;
	}
	
	@Override
	public String toString() {
		
		String napis = String.format("%s %5f %s %5f %s %6s%s","|",etat,"|",stawka,"|",String.valueOf(Pensja()),"|");
		
		return napis;
	}
	
	@Override
	public double Pensja() {
		return stawka*etat;
	}
	 
	
}
