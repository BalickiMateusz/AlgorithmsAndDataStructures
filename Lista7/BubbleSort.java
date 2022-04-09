package Lab7;

public class BubbleSort implements ArraySorter { 
	

	
	public BubbleSort() {

	}
	
	@Override
	public int[] sort(int[] array) { 
		
		int size = array.length;
		
		for (int pass = 1; pass < size; ++pass) {
			for (int left = 0; left < (size - pass); ++left) { 
				
				int right = left + 1;
				
				if (array[left]-array[right] > 0) {
					
					swap(array, left, right);
				}				
			}		
		}
		return array;
	}
	
	private void swap(int[] array, int left, int right) { 
		
		int temp = array[left];  
		
		array[left] = array[right]; 
		array[right] = temp;
	}
}

