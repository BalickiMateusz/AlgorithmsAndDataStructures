package Lab7;

public class InsertSort implements ArraySorter { 
	
	public InsertSort(){ //szukamy od prawej strony
	}
	
	public int[] sort(int[] array) { 
	
	for (int i = 1; i < array.length; ++i) { 
		
		int value = array[i],temp;
		
		int j;
		
		for (j = i; j > 0 && value - (temp=array[j - 1])< 0; --j) {
			array[j] = temp;
		}
		
		array[j] = value;
	}
	return array;
	}
	
}
