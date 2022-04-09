package Lab6;

public class Magazyn {
	
	private ListQueue<Klient> MagazynKolejka;
	
	public Magazyn() {
		MagazynKolejka = new ListQueue<Klient>();
	}

	public ListQueue<Klient> getMagazynKolejka() {
		return MagazynKolejka;
	}

	public void setMagazynKolejka(ListQueue<Klient> MagazynKolejka) {
		this.MagazynKolejka = MagazynKolejka;
	}

	@Override
	public String toString() {
		return "Magazyn [MagazynKolejka=" + MagazynKolejka + "]";
	}
		
	public void dodajKlienta(Klient klient) {
		try {
			MagazynKolejka.enqueue(klient);
			}catch(FullQueueException e) {
				e.printStackTrace();
			}
	}
	
	public void usunKlienta() {
		try {
			MagazynKolejka.dequeue();
		}catch(EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	public double RealizujZamowieniaKlienta(Klient klient) {		
		double sumaCen=0;
		
		try {			
			ListQueue<Zamowienie> klientKolejka= klient.getKlientKolejka();	
			
			while(!klientKolejka.isEmpty())
			{
				Zamowienie zamowienie = klientKolejka.dequeue();
				double cena = zamowienie.getLiczbaSztuk()* zamowienie.getCenaJednostkowa();
				sumaCen+=cena;
				System.out.println("Zamowienie: "+zamowienie.getNazwaTowaru()+" Cena: "+cena);
			}
			System.out.println("Zlecenia zrealizowane: "+klient.getNazwa()+" kwota="+sumaCen);
			System.out.println();
		}catch(EmptyQueueException e) {
			e.printStackTrace();
		}
		return sumaCen;
	}
	
	public double RealizujWszystkieZamowienia() {
		double sumaCen=0;

		try {
			while(!MagazynKolejka.isEmpty()) {
				sumaCen+=RealizujZamowieniaKlienta(MagazynKolejka.dequeue());
			}
		}catch(EmptyQueueException e) {
			e.printStackTrace();
		}		
		return sumaCen;
	}
}
