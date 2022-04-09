package Lab7;

public class SelectSort implements ArraySorter { 
	
	public SelectSort() { 
		
	}
	
	@Override
	public int[] sort(int[] array) { 
		int size = array.length;
		
		for (int slot = 0; slot < size - 1; ++slot) { 
			
			int smallest = slot; 
			
			for (int check = slot + 1; check < size; ++check) { 
				
				if (array[check] - array[smallest] < 0) {
					smallest = check;
				}
			}
			
			swap(array, smallest, slot);
		}
		return array;
	}
	private void swap(int[] array, int left, int right) { 
		
		if (left != right) { 
			
			int temp = array[left]; 
			
			array[left] = array[right]; 
			array[right] = temp;
		}
	}
}
