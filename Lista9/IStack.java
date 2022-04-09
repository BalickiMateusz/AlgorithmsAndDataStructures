package Lab9;

public interface IStack<T> {

	boolean isEmpty();//zwraca true, jeœli stos jest pusty
	boolean isFull();//zwraca true, jeœli stos jest pe³ny
	void push(T element) throws PelnyStosException;//umieszcza element na szczycie stosu
	T pop() throws PustyStosException;//zwraca element ze szczytu stosu
	int size();//zwraca liczbê elementów na stosie
	T top() throws PustyStosException;//zwraca element ze szczytu stosu bez usuwania
}
