package Lab8;

import java.util.Arrays;
import java.util.Random;

public class Dane {
	
	private int[] losowe;

	public Dane(int k) { 
	
		losowe = new int[k];
		Random rd = new Random();
	
		for(int i=0; i<k; i++) {
			losowe[i] = rd.nextInt(k);
		}			
	}
	
	public int[] getLosowe() {
		return Arrays.copyOf(losowe, losowe.length);
	}
	public void setLosowe(int[] losowe) {
		this.losowe = losowe;
	}

	@Override
	public String toString() {
		return "Dane [losowe=" + Arrays.toString(losowe) + "]";
	}	
}	
