package Lab9;

public class ListQueue<E> implements IQueue<E> {
	
	OneWayLinkedListWithHeadAndTail<E> lista;
	
	public ListQueue() {
		lista = new OneWayLinkedListWithHeadAndTail<E>();
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
	public E dequeue() throws EmptyQueueException {
		E value = lista.removeFirst();
		if(value==null) throw new EmptyQueueException();
		return value;
	}
	
	@Override
	public void enqueue(E elem) {
		lista.add(elem);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return lista.size();
	}
	
	@Override
	public E first() throws EmptyQueueException {
		E value = lista.getFirst();
		if(value==null) throw new EmptyQueueException();
		return value;
	}
	
	public void wypisz() {
		for(int i=0; i<lista.size();i++) {
			System.out.print(lista.get(i));
		}
	}
}
