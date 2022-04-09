package Lab7;

import java.util.Arrays;

public class BubbleSort3 implements ArraySorter { 
	
	public static void wypisz(int[] array) {
		/*for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
		}*/
		System.out.println(Arrays.toString(array));
		System.out.println();
	}
	
	public BubbleSort3() {

	}
	
	@Override
	public int[] sort(int[] array) { 
		
		int size = array.length;
		int h=1;
		
		for (int pass = 1; pass <= (size-1)/h; ++pass) {
			for (int left = 0; left < (size - pass*h); ++left) { 
				
				int right = left + h;
				
				if (array[left]-array[right] > 0) {
					
					int temp = array[left];  						
					array[left] = array[right]; 
					array[right] = temp;
				}				
			}	
			wypisz(array);
		}		
		return array;
	}
	
	private void swap(int[] array, int left, int right) { 
		
		int temp = array[left];  
		
		array[left] = array[right]; 
		array[right] = temp;
	}
}

