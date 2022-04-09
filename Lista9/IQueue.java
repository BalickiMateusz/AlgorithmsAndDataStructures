package Lab9;

public interface IQueue<T> {
	  boolean isEmpty();
	  boolean isFull();
	  T dequeue() throws EmptyQueueException;
	  void enqueue(T elem) throws FullQueueException;
	  int size(); 
	  T first() throws EmptyQueueException; 
}

