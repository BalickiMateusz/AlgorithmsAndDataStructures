package Lab7;

import java.util.NoSuchElementException;

public class MergeSort implements ArraySorter{
	
	public MergeSort(){ 
	}
	
	@Override
	public int[] sort(int[] array)	{ 
		
		return mergesort(array, 0, array.length - 1); 
	}
	
	
	private int[] mergesort(int[] array, int startIndex, int endIndex) { 
		
		if (startIndex == endIndex) {
			
			int[] result = new int[1]; 
			result[0]=array[startIndex];
	 		
			return result;
		}
		
	int splitIndex = startIndex + (endIndex - startIndex) / 2; 
	
	return merge(mergesort(array, startIndex, splitIndex), mergesort(array, splitIndex + 1, endIndex)); 
	}

	
	private int[] merge(int[] left, int[] right) {
		
		int[] result = new int[left.length+right.length];
		
		ArrayIterator l = new ArrayIterator(left);
		ArrayIterator r = new ArrayIterator(right);
		
		int elemL=l.next() ,elemR=r.next();
		boolean contL=true, contR=true; 
		int pos = 0;
		
		while (contL && contR) { 
			
			if (elemL - elemR <= 0){ 
				
				result[pos]=elemL; 
				pos++;
				
				if(contL=l.hasNext()) {
					elemL=l.next();
				}			
				else {
					result[pos] = elemR;
					pos++;
				}
			}
			else { 
				result[pos]=elemR;
				pos++;
						
				if(contR=r.hasNext()) {
					elemR=r.next(); 
				}else {
					result[pos] = elemL;
					pos++;
				}
			}
		}
		
		while(l.hasNext()) {
			result[pos] = l.next(); 
			pos++;
		}
		
		while(r.hasNext()) {
			result[pos] = r.next(); 
			pos++;
		}
		
		return result;
	}
	
	private class ArrayIterator {
		
		  private int array[];	  
		  private int pos = 0;

		  public ArrayIterator(int anArray[]) {
		    array = anArray;
		  }
		  
		  public boolean hasNext() {
		    return pos < array.length;
		  }
		  
		  public int next() throws NoSuchElementException {
		    if (hasNext())
		      return array[pos++];
		    else
		      throw new NoSuchElementException();
		  }
		  
		  public void remove() {
		    throw new UnsupportedOperationException();
		  }
	}
	
}
