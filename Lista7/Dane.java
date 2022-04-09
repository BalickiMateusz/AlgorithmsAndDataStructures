package Lab7;

import java.util.Arrays;
import java.util.Random;

public class Dane {
	
	private int[] losowe = new int[10];
	private int[] rosnace = new int[10];
	private int[] malejace = new int[10];
	
	public Dane() { 
	
	Random rd = new Random();
	
		for(int i=0; i<losowe.length; i++) {
			losowe[i] = rd.nextInt(9999);
		}
		
		for(int i=0; i<rosnace.length; i++) {
			rosnace[i] = i;
		}
		
		for(int i=0; i<malejace.length; i++) {
			malejace[i]=9-i;
		}		
	}
	
	public int[] getLosowe() {
		return Arrays.copyOf(losowe, losowe.length);
	}
	public void setLosowe(int[] losowe) {
		this.losowe = losowe;
	}
	public int[] getRosnace() {
		return Arrays.copyOf(rosnace, rosnace.length);
	}
	public void setRosnace(int[] rosnace) {
		this.rosnace = rosnace;
	}
	public int[] getMalejace() {
		return Arrays.copyOf(malejace, malejace.length);
	}
	public void setMalejace(int[] malejace) {
		this.malejace = malejace;
	}

	@Override
	public String toString() {
		return "Dane [losowe=" + Arrays.toString(losowe) + ", rosnace=" + Arrays.toString(rosnace) + ", malejace="
				+ Arrays.toString(malejace) + "]";
	}	
}	
