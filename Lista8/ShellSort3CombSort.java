package Lab8;

import java.util.ArrayList;

public class ShellSort3CombSort implements ArraySorter {
	
	private ArrayList<Integer> wartosci_h;
	
	public ShellSort3CombSort(){
	}
	
	public int[] sort(int[] array, ArrayList<Integer> wartosci_h) { 
		
	if(array==null) {
		System.out.println("Lista pusta!");
	}
	
	int h;
	
	for(int i=0; i< wartosci_h.size(); ++i) {
			
		h=wartosci_h.get(i);
		int size = array.length;
		
		if(h>1) {
					
				for (int left = 0; left < (size - h); ++left) { 
					
					int right = left + h;
					
					if (array[left]-array[right] > 0) {
						
						int temp = array[left];  						
						array[left] = array[right]; 
						array[right] = temp;
					}				
				}					
			
		}
		else {
				
			for (int x = 1; x < size; ++x) { 
				
				int value = array[x],temp;
				
				int j;
				
				for (j = x; j > 0 && value - (temp=array[j - 1])< 0; --j) {
					array[j] = temp;
				}
				
				array[j] = value;
			}
			
		}
	}
	
	return array;
	}
	
}


