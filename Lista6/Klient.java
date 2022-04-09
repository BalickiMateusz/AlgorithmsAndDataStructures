package Lab6;

public class Klient {

	private ListQueue<Zamowienie> KlientKolejka;
	private String nazwa;
	public Klient(String nazwa) {
		KlientKolejka = new ListQueue<Zamowienie>();
		this.nazwa=nazwa;
	}
	
	public ListQueue<Zamowienie> getKlientKolejka() {
		return KlientKolejka;
	}

	public void setKlientKolejka(ListQueue<Zamowienie> KlientKolejka) {
		this.KlientKolejka = KlientKolejka;
	}
 	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	@Override
	public String toString() {
		return "Klient [KlientKolejka=" + KlientKolejka + "]";
	}
	
	public void dodajZamowienie(Zamowienie zamowienie) {
		try {
		KlientKolejka.enqueue(zamowienie);
		}catch(FullQueueException e) {
			e.printStackTrace();
		}
	}
	
	public void usunZamowienie() {
		try {
			KlientKolejka.dequeue();
		}catch(EmptyQueueException e) {
			e.printStackTrace();
		}
	}
}
