package Zadanie1b;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTab<T> implements Iterator<T> {
	  private T tab[];
	  private int pos = 0;

	  public IteratorTab(T tablica[]) {
	    tab = tablica;
	  }
	  public boolean hasNext() {
	    return pos < tab.length;
	  }
	  public T next() throws NoSuchElementException {
	    if (hasNext())
	      return tab[pos++];
	    else
	      throw new NoSuchElementException();
	  }
	}

