package Zadanie;

import Zadanie.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<E> extends AbstractList<E> {

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	private final int initialCapacity;

	private E[] array;
	
	private int size;

	public  ArrayList(int capacity){
		if(capacity<=0)
		capacity=DEFAULT_INITIAL_CAPACITY;
		initialCapacity=capacity;
		array=(E[])(new Object[capacity]);
		size=0;
	}

	public  ArrayList(){
		this(DEFAULT_INITIAL_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		if (array.length < capacity) {
			E[] copy = (E[])(new Object[capacity + capacity / 2]);
			System.arraycopy(array, 0, copy, 0, size);
			array = copy;
		}
	}
	
	private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>=size) throw new IndexOutOfBoundsException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array=(E[])(new Object[initialCapacity]);
		size=0;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean add(E value) {
		ensureCapacity(size+1);
		array[size]=value;
		size++;
		return true;
	}

	@Override
	public boolean add(int index, E value) {
		if(index<0 || index>size) throw new IndexOutOfBoundsException();
		ensureCapacity(size+1);
		if(index!=size)
			System.arraycopy(array, index, array, index+1, size - index);
		array[index]=value;
		size++;
		return false;
	}

	@Override
	public int indexOf(E value) {
		int i =0;
		while(i < size && !value.equals(array[i]))
			++i;
		return i<size ? i : -1;
	}

	@Override
	public boolean contains(E value) {
		return indexOf(value) != -1;
	}

	@Override
	public E get(int index) {
		checkOutOfBounds(index);
		return array[index];
	}

	@Override
	public E set(int index, E element) {
		checkOutOfBounds(index);
		E retValue=array[index];
		array[index]=element;
		return retValue;
	}

	@Override
	public E remove(int index) {
		checkOutOfBounds(index);
		E retValue = array[index];
		int copyFrom = index + 1;
		if (copyFrom < size)
			System.arraycopy(array, copyFrom, array, index, size - copyFrom);
		--size;
		return retValue;
	}

	@Override
	public boolean remove(E value) {
		int pos=0;
		while(pos<size && !array[pos].equals(value))
			pos++;
		if(pos<size){
			remove(pos);
			return true;
		}
		return false;			
	}


	private class InnerIterator implements Iterator<E>{

		int pos=0;
		@Override
		public boolean hasNext() {
			return pos<size;
		}

		@Override
		public E next() {			
			return array[pos++];
		}
		
	}
	





	@Override
	public Iterator<E> iterator() {
		return new InnerIterator();
	}
	

	@Override
	public ListIterator<E> listIterator() {
		return new InnerListIterator();
	}
	
	private class InnerListIterator implements ListIterator<E>{
		int pos=0;
		@Override
		public void add(E Value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return pos<size;
		}

		@Override
		public boolean hasPrevious() {
			
			return pos>=0;
		}

		@Override
		public E next() {
			return array[pos++];
		}

		@Override
		public int nextIndex() {
			return pos;
		}

		@Override
		public E previous() {
			return array[--pos];
		}

		@Override
		public int previousIndex() {
			return pos-1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();			
		}
		
	}

}
