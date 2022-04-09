package Lab8;

import java.util.ArrayList;

public class ShellSort2 implements ArraySorter {//Sam InsertSort
	
	private ArrayList<Integer> wartosci_h;
	
	public ShellSort2(){
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
				
			for (int k = h; k < size; ++k) { 
				
				int temp = array[k];
				
				int j;
				
				for (j = k; j >= h && temp - array[j - h]< 0; j-=h) {
					array[j] = array[j - h];
				}
				
				array[j] = temp;
			}
		}
		else {
				
			for (int pass = 1; pass < size; ++pass) {
				for (int left = 0; left < (size - pass); ++left) { 
					
					int right = left + 1;
					
					if (array[left]-array[right] > 0) {
						
						int temp = array[left];  						
						array[left] = array[right]; 
						array[right] = temp;
					}				
				}		
			}
			
		}
	}
	
	return array;
	}
	
}


