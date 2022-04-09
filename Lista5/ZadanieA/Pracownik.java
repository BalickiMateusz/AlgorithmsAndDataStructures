package Zadanie5;

import java.io.Serializable;

public class Pracownik implements Serializable {
		
		private static final long serialVersionUID = 7829136421241571165L;
	
		private long PESEL;
		private String Nazwisko;
		private String Imie;
		private String Data_urodzenia;
		private String Stanowisko;
		private double Pensja;
		private double Sta¿;
		private double Premia;
		
		public Pracownik() {
			PESEL = 0;
			Nazwisko = " ";
			Imie = " ";
			Data_urodzenia = "00/00/0000";
			Stanowisko = " ";
			Pensja = 0;
			Sta¿ = 0;
			Premia = 0;
		}
		
		public Pracownik(long pesel, String nazwisko, String imie, String data_urodzenia, String stanowisko, double pensja, double sta¿) {
			PESEL = pesel;
			Nazwisko = nazwisko;
			Imie = imie;
			Data_urodzenia = data_urodzenia;
			Stanowisko = stanowisko;
			Pensja = pensja;
			Sta¿ = sta¿;
			
			if(Sta¿ >= 20) {
				Premia = Pensja*0.2;
			}else if((Sta¿ < 20) && (Sta¿ >= 10)) {
				Premia = Pensja*0.1;
			}else if(Sta¿ < 10) {
				Premia = 0;
			}
			
		}
		
		public long getPESEL() {
			return PESEL;
		}
		public String getNazwisko() {
			return Nazwisko;
		}
		public String getImie() {
			return Imie;
		}
		public String getData_urodzenia() {
			return Data_urodzenia;
		}
		public String getStanowisko() {
			return Stanowisko;
		}
		public double getPensja() {
			return Pensja;
		}
		public double getSta¿() {
			return Sta¿;
		}
		public double getPremia() {
			return Premia;
		}
		public void setPESEL(long pESEL) {
			PESEL = pESEL;
		}
		public void setNazwisko(String nazwisko) {
			Nazwisko = nazwisko;
		}
		public void setImie(String imie) {
			Imie = imie;
		}
		public void setData_urodzenia(String data_urodzenia) {
			Data_urodzenia = data_urodzenia;
		}
		public void setStanowisko(String stanowisko) {
			Stanowisko = stanowisko;
		}
		public void setPensja(double pensja) {
			Pensja = pensja;
		}
		public void setSta¿(double sta¿) {
			Sta¿ = sta¿;
		}
		public void setPremia(double premia) {
			Premia = premia;
		}
		
		public void aktualizujPremia() {
			if(Sta¿ >= 20) {
				Premia = Pensja*0.2;
			}else if((Sta¿ < 20) && (Sta¿ >= 10)) {
				Premia = Pensja*0.1;
			}else if(Sta¿ < 10) {
				Premia = 0;
			}
		}
		@Override
		public String toString() {
			return "Pracownik [PESEL=" + PESEL + ", Nazwisko=" + Nazwisko + ", Imie=" + Imie + ", Data_urodzenia="
					+ Data_urodzenia + ", Stanowisko=" + Stanowisko + ", Pensja=" + Pensja + ", Sta¿=" + Sta¿
					+ ", Premia=" + Premia + "]";
		}
		
		
}
