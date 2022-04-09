package Lab7;

public class BubbleSort2 implements ArraySorter { 
	

	
	public BubbleSort2() {

	}
	
	@Override
	public int[] sort(int[] array) { 
		
		int lastSwap = array.length-1; 
		
			while(lastSwap>0){ 
				
				int end=lastSwap; 
				lastSwap=0;
				
				for (int left = 0; left < end; ++left) { 
					
					if (array[left] - array[left+1] > 0) { 
						
						int temp=array[left];
						
						while(left<end && temp - array[left+1] > 0) { 
							
							array[left] = array[left+1]; 
							left++; 
						}
						
						lastSwap=left; 
						array[left] = temp;
					}
				}
			} 
			return array;
	}
}
