package Lab9;

public interface IStack<T> {

	boolean isEmpty();//zwraca true, je�li stos jest pusty
	boolean isFull();//zwraca true, je�li stos jest pe�ny
	void push(T element) throws PelnyStosException;//umieszcza element na szczycie stosu
	T pop() throws PustyStosException;//zwraca element ze szczytu stosu
	int size();//zwraca liczb� element�w na stosie
	T top() throws PustyStosException;//zwraca element ze szczytu stosu bez usuwania
}
