package Lab8;

import java.util.ArrayList;

public class ShellSort1 implements ArraySorter {//Sam InsertSort
	
	private ArrayList<Integer> wartosci_h;
	
	public ShellSort1(){
	}
	
	public int[] sort(int[] array, ArrayList<Integer> wartosci_h) { 
		
	if(array==null) {
		System.out.println("Lista pusta!");
	}
	
	int h;
	
	for(int i=0; i< wartosci_h.size(); ++i) {
			
		h=wartosci_h.get(i);
		
		for (int k = h; k < array.length; ++k) { 
			
			int temp = array[k];
			
			int j;
			
			for (j = k; j >= h && temp - array[j - h]< 0; j-=h) {
				array[j] = array[j - h];
			}
			
			array[j] = temp;
		}	
	}
	
	return array;
	}
	
}


