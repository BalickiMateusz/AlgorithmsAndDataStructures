package Lab6;

import java.util.Iterator;
import java.util.ListIterator;

public class OneWayLinkedListWithHeadAndTail<E> extends AbstractList<E>{
	private class Element{

		private E value;
		private Element next;

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Element getNext() {
			return next;
		}

		public void setNext(Element next) {
			this.next = next;
		}



		Element(E data){
			this.value=data;
		}
	}

	Element head=null;
	Element tail=null;

	public OneWayLinkedListWithHeadAndTail(){
	}

	public boolean isEmpty(){
		return head==null;
	}
	
	@Override
	public void clear() {
		head=null;
		tail=null;
	}
	
	@Override
	public int size() {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			pos++;
			actElem=actElem.getNext();
		}
		return pos;
	}

	private Element getElement(int index){
		Element actElem=head;
		while(index>0 && actElem!=null){
			index--;
			actElem=actElem.getNext();
		}
		return actElem;		
	}
	
	@Override
	public boolean add(E e) {
		Element newElem=new Element(e);
		if(head==null){
			head=newElem;
			tail=newElem;
			return true;
		}
		tail.setNext(newElem);
		tail = newElem;
		return true;
	}
	
	public boolean DodajNaPoczatek(E e){
		
		Element newElem=new Element(e);
		if(head!=null)
		{
		newElem.setNext(head);
		head=newElem;
		return true;
		}
		else if(head==null) {
			head=newElem;
			tail=newElem;
			return true;
		}
	return true;
	}
	
	@Override
	public boolean add(int index, E data) {
		
		if(index<0) return false;
		
		Element newElem=new Element(data);
		
		if(index==0)
		{
			return DodajNaPoczatek(data);
		}
		
		if(index==indexOf(tail)) 
		{
			return add(data);
		}
		
		Element actElem=getElement(index-1);
		
		if(actElem==null) return false;
		
		newElem.setNext(actElem.getNext());
		actElem.setNext(newElem);
		
		return true;
	}

	@Override
	public int indexOf(E data) {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			if(actElem.getValue()==data)
				return pos;
			pos++;
			actElem=actElem.getNext();
		}
		return -1;
	}

	private int indexOf(Element e) {
		int pos=0;
		Element actElem=head;
		while(actElem!=null)
		{
			if(actElem==e)
				return pos;
			pos++;
			actElem=actElem.getNext();
		}
		return -1;
	}
	
	@Override
	public boolean contains(E data) {
		return indexOf(data)>=0;
	}

	@Override
	public E get(int index) {
		Element actElem=getElement(index);
		return actElem==null?null:actElem.getValue();
	}
	
	public E getFirst() {
		return head.getValue();
	}
	
	public E getLast() {
		return tail.getValue();
	}
	
	@Override
	public E set(int index, E data) {
		Element actElem=getElement(index);
		
		if(actElem==null) return null;
		
		E elemData=actElem.getValue();
		
		actElem.setValue(data);
		
		return elemData;
	}
	
	public E removeFirst() {
		E retValue=head.getValue();
		head=head.getNext();
		return retValue;
	}
	
	public E removeLast() {
		
		Element actElem=getElement(indexOf(tail)-1);		
		E retValue=actElem.getNext().getValue();	
		actElem.setNext(null);
		tail=actElem;
		
		return retValue;
	}
	
	@Override
	public E remove(int index) {
		if(head==null)	return null;
		
		if(index==0){
			E retValue=head.getValue();
			head=head.getNext();
			return retValue;
		}

		Element actElem=getElement(index-1);
		
		if(actElem==null || actElem.getNext()==null) return null;
		
		if(actElem.getNext()==tail) {
			
			E retValue=actElem.getNext().getValue();	
			actElem.setNext(null);
			tail=actElem;
			
			return retValue;
		}
		
		E retValue=actElem.getNext().getValue();		
		actElem.setNext(actElem.getNext().getNext());
		
		return retValue;
	}

	@Override
	public boolean remove(E value) {
		
		if(head==null)	return false;
		
		if(head.getValue().equals(value)){
			head=head.getNext();
			return true;
		}
			
		Element actElem=head;
		while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value))
			actElem=actElem.getNext();

		if(actElem.getNext()==null)	return false;
		
		if(actElem.getNext()==tail) {
			
			actElem.setNext(null);
			tail = actElem;
			return true;
		}
			
		actElem.setNext(actElem.getNext().getNext());
		
		return true;
	}


	private class InnerIterator implements Iterator<E>{
		Element actElem;
		public InnerIterator() {
			actElem=head;
		}
		@Override
		public boolean hasNext() {
			return actElem!=null;
		}
		@Override
		public E next() {
			E value=actElem.getValue();
			actElem=actElem.getNext();
			return value;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new InnerIterator();
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	
}
