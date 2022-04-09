package Lab7;

import java.util.Random;

public class QuickSort implements ArraySorter { 
	
	public QuickSort(){ 
	}
	
	@Override
	public int[]  sort(int[] array) { 
		quicksort(array, 0, array.length);
		return array;
	}

	private void quicksort(int[]  array, int startIndex, int endIndex) { 
	
		if (endIndex - startIndex > 1) { 
			
			int partition = partition(array, startIndex, endIndex); 
			
			quicksort(array, startIndex, partition ); 
			quicksort(array, partition + 1, endIndex);
		}
	}

	private int partition(int[] array, int nFrom, int nTo) {
		
		Random random = new Random();
		
		int rnd=nFrom+random.nextInt(nTo-nFrom); 		
		swap(array,nFrom,rnd); 
		
		int value=array[nFrom];
		int idxBigger=nFrom+1,idxLower=nTo-1; 
		
		do{ 
			
			while(idxBigger<=idxLower && array[idxBigger] - value<=0) {
				idxBigger++;
			}
			
			while(array[idxLower] - value>0) {
				idxLower--;
			}
			
			if(idxBigger<idxLower) {
				swap(array,idxBigger,idxLower);
			}
			
		}while(idxBigger<idxLower); 
		
	swap(array,idxLower,nFrom); 
	
	return idxLower;
	}
	
	private void swap(int[] array, int left, int right) { 
		
		if (left != right) { 
			int temp = array[left]; 
			array[left] = array[right]; 
			array[right] = temp;
		} 
	}
}