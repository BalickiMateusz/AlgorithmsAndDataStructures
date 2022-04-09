package Lab9;

import java.util.HashMap;
import java.util.Map;

public class ONP {
	
	private ListStack<Character> stos;
	private ListQueue<Character> kolejka;
	private Map<Character, Integer> operatory;
	
	public ONP() {
		stos = new ListStack<Character>();
		kolejka = new ListQueue<Character>();
		operatory = new HashMap <Character, Integer>();
			
		operatory.put('(',0);
		operatory.put('+',1);
		operatory.put('-',1);
		operatory.put('*',2);
		operatory.put('/',2);
		operatory.put('%',3);
	}
	

	
	public String Konwetruj(String wyrazenie){
		
		try {
			
			for(int i=0; i<wyrazenie.length(); i++) {
				
				Character token = wyrazenie.charAt(i);
				Character a = 32;
					
				if(Character.isDigit(token)) {
					
					while(i<wyrazenie.length() && Character.isDigit(wyrazenie.charAt(i))) {
						
					kolejka.enqueue(wyrazenie.charAt(i));
					i++;
					}
					
					i--;
					kolejka.enqueue(a);				
				}
				else if(((Character)'(').equals(token)) {
					
					stos.push(token);
				}
				
				else if(((Character)')').equals(token)) {
					
					while(!((Character)'(').equals(stos.top())) {
						kolejka.enqueue(stos.pop());
					}
					kolejka.enqueue(a);	
					stos.pop();
				}
				
				else if(operatory.containsKey(token)) {
					
					while((!stos.isEmpty()) && (operatory.get((stos.top())) >= operatory.get(token))) {
						kolejka.enqueue(stos.pop());
						kolejka.enqueue(a);
					}
	
					stos.push(token);
					
					
				}
				
				else {
					
					System.out.println("Niepoprawny symbol!");						
					throw new IllegalArgumentException();					
				}
				
			}
			
			while(!stos.isEmpty()) {
				kolejka.enqueue(stos.pop());
			}
			
			String wynik="";
			
			while(!kolejka.isEmpty()) {
				wynik+=kolejka.dequeue();
			}
			
			return wynik;
			
		}catch(PustyStosException | IllegalArgumentException | EmptyQueueException e) {
			e.printStackTrace();
			return "";
		}
	}
}
