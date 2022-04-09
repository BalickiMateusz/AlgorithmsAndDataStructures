package Lab12;

import java.util.Comparator;

public class PriorityQueueHeap<T> implements IQueue<T>, Cloneable {
	
	private final IList<T> _list;

	private final Comparator<T> _comparator;

	public PriorityQueueHeap(Comparator<T> comparator) {
	
		_comparator = comparator;
		_list = new ArrayList<T>();
	}
	
	public IList<T> get_list() {
		return _list;
	}

	public void enqueue(T value) {
		
		_list.add(value);
		swim(_list.size() -1);
	}
	
	public void clear(){
		_list.clear();
	}
	
	public int size(){
		
		return _list.size();
	}
	
	public	boolean	isEmpty(){
		
		return _list.isEmpty();
	}
	
	public	boolean	isFull() {
		
		return false;
	}
	
	public T first() throws EmptyQueueException{
		
		if(isEmpty()) throw new EmptyQueueException();
		return _list.get(0);
	}
	
	public T dequeue() throws EmptyQueueException{
		
		if(isEmpty()) throw new EmptyQueueException();
		
		T result = _list.get(0);
		
		if(_list.size() > 1) {
			
			_list.set(0, _list.get(_list.size() -1));
			sink(0);
		}
		
		_list.remove(_list.size() -1);
		return result;
	}
	
	private void swap(int index1, int index2) {
		
		T temp = _list.get(index1);
		_list.set(index1, _list.get(index2));
		_list.set(index2, temp);
	}
	
	private void swim(int index) {
		
		int parent;
		
		while(index!= 0 &&_comparator.compare(_list.get(index), _list.get(parent= (index-1) / 2)) > 0){ 
			
			swap(index, parent);
			index=parent;
		}
	}
	
	private void sink(int index) {
		
		boolean isDone=false;
		int child;
		
		while(!isDone && (child=2*index+ 1 ) < _list.size()) {
			
			if(child< _list.size()-1 &&_comparator.compare(_list.get(child), _list.get(child+1)) < 0) ++child;
			
			if(_comparator.compare(_list.get(index), _list.get(child)) < 0){
				
				swap(index, child);
				index=child;
			}
			else isDone=true;
		}
	}
	
	@Override
	public PriorityQueueHeap<T> clone() throws CloneNotSupportedException {
	    return (PriorityQueueHeap<T>) super.clone();
	}
}
