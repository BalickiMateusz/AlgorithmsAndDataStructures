package Zadanie5b;

public class Parking {
	
	private ListStack<Pracownik> stos;

	public Parking() {
		stos = new ListStack<Pracownik>();
	}

	public ListStack<Pracownik> getStos() {
		return stos;
	}

	public void setStos(ListStack<Pracownik> stos) {
		this.stos = stos;
	}
	
	public void Wjazd(Pracownik prac) {
		try {
		stos.push(prac);
		}catch(PelnyStosException e) {
			e.printStackTrace();
		}
	}
	
	public void Wyjazd(int index) {
		if(stos.isEmpty()) {
			System.out.println("Stos jest pusty!");
			return;
		}else {
			try {
			ListStack<Pracownik> stack2 = new ListStack<Pracownik>(); 
			
			for(int i=0;i<=index;i++) {	
				System.out.println("Proszony o wyjazd: "+stos.top());
				stack2.push(stos.pop());				
			}
			System.out.println("\nWyjechal zgloszony pracownik!\n");
			
			Pracownik usuniety = stack2.pop();		
			
			while(!stack2.isEmpty()) {
				System.out.println("Wjezdza pracownik: "+stack2.top());
				stos.push(stack2.pop());
			}
			
			
			}catch(PelnyStosException | PustyStosException e) {
			
			}
		}
	}
	
	public void Wyswietl(ListStack<Pracownik> stos) {	
	try {
		if(stos.isEmpty()) {
			return;
		}
		Pracownik x = stos.top();
		stos.pop();
		Wyswietl(stos);
		System.out.println(x+" ");
		stos.push(x);
		}catch(PelnyStosException | PustyStosException e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Parking [stos=" + stos + "]";
	}
}
