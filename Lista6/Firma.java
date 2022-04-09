package Lab6;

public class Firma {
	
	private ListQueue<Magazyn> FirmaKolejka;

	public Firma() {
		FirmaKolejka = new ListQueue<Magazyn>();
	}

	public ListQueue<Magazyn> getFirmaKolejka() {
		return FirmaKolejka;
	}

	public void setFirmaKolejka(ListQueue<Magazyn> firmaKolejka) {
		FirmaKolejka = firmaKolejka;
	}

	@Override
	public String toString() {
		return "Firma [FirmaKolejka=" + FirmaKolejka + "]";
	}
	
	public void dodajMagazyn(Magazyn magazyn) {
		try {
			FirmaKolejka.enqueue(magazyn);
			}catch(FullQueueException e) {
				e.printStackTrace();
			}
	}
	
	public void usunMagazyn() {
		try {
			FirmaKolejka.dequeue();
		}catch(EmptyQueueException e) {
			e.printStackTrace();
		}
	}
	
	public void ObliczPrzychodyFirmy() {
		double przychody = 0;
		
		while(!FirmaKolejka.isEmpty()) {
			try {
			przychody += FirmaKolejka.dequeue().RealizujWszystkieZamowienia();
			}catch(EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Przychody firmy: "+przychody);
	}
	
}
