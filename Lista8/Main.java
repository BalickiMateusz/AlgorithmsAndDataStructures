package Lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static long startTime;
 	private static long stopTime;
 	
	public static void wypisz(int[] array) {
		/*for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
		}*/
		System.out.println(Arrays.toString(array));
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Ciagi ciag = new Ciagi();
		List<Dane> dane = Arrays.asList(new Dane(5000),new Dane(10000),new Dane(50000),new Dane(100000)) ;		
		ArrayList<ArrayList<Integer>> ciagi = new ArrayList<ArrayList<Integer>>();
		
		ShellSort1 shellSort1= new ShellSort1();
		ShellSort2 shellSort2= new ShellSort2();
		ShellSort3 shellSort3= new ShellSort3();
		ShellSort3CombSort shellSort3CombSort= new ShellSort3CombSort();
		
		for(Dane x:dane) {
			
			int length = x.getLosowe().length;
			System.out.println("Dla "+length+" elementow tablicy: \n");
			//System.out.println("Przed sortowaniem: ");
			//wypisz(x.getLosowe());
					
			ciagi.add(ciag.ciagA(length));
			ciagi.add(ciag.ciagB(length));
			ciagi.add(ciag.ciagC(length));
			ciagi.add(ciag.ciagD(length));
			ciagi.add(ciag.ciagE(length));
			
			int j=1;
			
			for(ArrayList<Integer> i:ciagi) {
						
				System.out.println("\nDla ciagu z podpunktu: "+j++);
				System.out.println(i);
				System.out.println("\nInsertsort we wszystkich sortowniach „co h”  i „co 1”:");
				//wypisz(shellSort1.sort(x.getLosowe(), i));
				startTime = System.nanoTime();
				shellSort1.sort(x.getLosowe(), i);
				stopTime = System.nanoTime();
				System.out.println("Czas wykonania: "+(stopTime - startTime));
				
				System.out.println("\nInsertsort w sortowaniu „co h” i bubblesort w sortowaniu „co 1”:");
				//wypisz(shellSort2.sort(x.getLosowe(), i));
				startTime = System.nanoTime();
				shellSort2.sort(x.getLosowe(), i);
				stopTime = System.nanoTime();
				System.out.println("Czas wykonania: "+(stopTime - startTime));
				
				System.out.println("\nBubblesort w sortowaniu „co h” i insertsort w sortowaniu „co 1”:");
				//wypisz(shellSort3.sort(x.getLosowe(), i));
				startTime = System.nanoTime();
				shellSort3.sort(x.getLosowe(), i);
				stopTime = System.nanoTime();
				System.out.println("Czas wykonania: "+(stopTime - startTime));
				
				System.out.println("\nCombSort w sortowaniu „co h” i insertsort w sortowaniu „co 1”:");
				//wypisz(shellSort3CombSort.sort(x.getLosowe(), i));
				startTime = System.nanoTime();
				shellSort3CombSort.sort(x.getLosowe(), i);
				stopTime = System.nanoTime();
				System.out.println("Czas wykonania: "+(stopTime - startTime));
				
				System.out.println("\n");
			}

			ciagi.clear();
		}
		
	}

}
