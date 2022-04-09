package Lab7;

public class HeapSort implements ArraySorter {
	
	public HeapSort(){ 
	}
	
	private void swap(int[] array, int left, int right) { 
		int temp = array[left]; 
		array[left] = array[right]; 
		array[right] = temp;
	}
	
	public void sink(int[] heap,int idx, int n){ 
		
		int idxOfBigger=2*idx+1; 
		
		if(idxOfBigger<n){ 
			
			if(idxOfBigger+1<n && heap[idxOfBigger] - heap[idxOfBigger+1]<0) {
				idxOfBigger++;
			}
			
			if(heap[idx] - heap[idxOfBigger]<0){ 
				swap(heap,idx,idxOfBigger); 
				sink(heap,idxOfBigger,n);
			}
		}
	}
	
	void heapAdjustment(int[] heap,int n){ 
		
		for(int i=(n-1)/2;i>=0;i--) {
			sink(heap, i, n);
		}
	}
	
	@Override
	public int[] sort(int[]  array){ 
		
		heapsort(array, array.length); 
		return array;
	}
	
	private void heapsort(int[]  heap, int n) { 
		
		heapAdjustment(heap, n); 
		
		for(int i=n-1;i>0;i--){ 
			swap(heap,i,0); 
			sink(heap,0,i);
		}
	}
}
