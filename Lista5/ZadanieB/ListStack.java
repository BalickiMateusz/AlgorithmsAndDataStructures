package Zadanie5b;

public class ListStack<E> implements IStack<E> {
	L1KPzG<E> lista;
	public ListStack(){
		lista = new L1KPzG<E>();
	}
	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	@Override
	public boolean isFull() {
		return false;
	}
	@Override
	public E pop() throws PustyStosException {
		E value=lista.remove(0);

		return value;
	}
	@Override
	public void push(E elem) throws PelnyStosException {
		lista.add(0,elem);	
	}
	@Override
	public int size() {
		return lista.size();
	}
	@Override
	public E top() throws PustyStosException {
		E value=lista.get(0);
		if(value==null) throw new PustyStosException(); 
		return value;
	}
}
