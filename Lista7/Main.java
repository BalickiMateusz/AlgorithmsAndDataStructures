package Lab7;

import java.util.Arrays;

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
		
		Dane dane = new Dane();
		System.out.println(dane);
		
		BubbleSort3 bubble = new BubbleSort3();
		bubble.sort(dane.getMalejace());
		System.out.println("\n\ninsertSort");
		InsertSort insertSort = new InsertSort();	
		System.out.println("\nLosowe:");
		
		//wypisz(insertSort.sort(dane.getLosowe()));
		startTime = System.nanoTime();
		insertSort.sort(dane.getLosowe());
		stopTime = System.nanoTime();		 
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nRosnace:");
		
		//wypisz(insertSort.sort(dane.getRosnace()));
		startTime = System.nanoTime();
		insertSort.sort(dane.getRosnace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nMalejace:");

		//wypisz(insertSort.sort(dane.getMalejace()));
		startTime = System.nanoTime();
		insertSort.sort(dane.getMalejace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		
		System.out.println("\n\nbubbleSort");
		BubbleSort bubbleSort = new BubbleSort();	
		System.out.println("\nLosowe:");
		
		//wypisz(bubbleSort.sort(dane.getLosowe()));
		startTime = System.nanoTime();
		bubbleSort.sort(dane.getLosowe());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nRosnace:");
		
		//wypisz(bubbleSort.sort(dane.getRosnace()));
		startTime = System.nanoTime();
		bubbleSort.sort(dane.getRosnace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nMalejace:");
		
		//wypisz(bubbleSort.sort(dane.getMalejace()));
		startTime = System.nanoTime();
		bubbleSort.sort(dane.getMalejace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		/*System.out.println("\n\nbubbleSort2");
		BubbleSort2 bubbleSort2 = new BubbleSort2();	
		System.out.println("\nLosowe:");
		
		//wypisz(bubbleSort2.sort(dane.getLosowe()));
		startTime = System.nanoTime();
		bubbleSort2.sort(dane.getLosowe());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nRosnace:");
		
		//wypisz(bubbleSort2.sort(dane.getRosnace()));
		startTime = System.nanoTime();
		bubbleSort2.sort(dane.getRosnace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nMalejace:");
		
		//wypisz(bubbleSort2.sort(dane.getMalejace()));
		startTime = System.nanoTime();
		bubbleSort2.sort(dane.getMalejace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));*/
		
		
		System.out.println("\n\nselectSort");
		SelectSort selectSort = new SelectSort();
		System.out.println("\nLosowe:");
	
		//wypisz(selectSort.sort(dane.getLosowe()));
		startTime = System.nanoTime();
		selectSort.sort(dane.getLosowe());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nRosnace:");
		
		//wypisz(selectSort.sort(dane.getRosnace()));
		startTime = System.nanoTime();
		selectSort.sort(dane.getRosnace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nMalejace:");
		
		//wypisz(selectSort.sort(dane.getMalejace()));
		startTime = System.nanoTime();
		selectSort.sort(dane.getMalejace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		
		System.out.println("\n\nquickSort");
		QuickSort quickSort = new QuickSort();	
		System.out.println("\nLosowe:");
		
		//wypisz(quickSort.sort(dane.getLosowe()));
		startTime = System.nanoTime();
		quickSort.sort(dane.getLosowe());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nRosnace:");
		
		//wypisz(quickSort.sort(dane.getRosnace()));
		startTime = System.nanoTime();
		quickSort.sort(dane.getRosnace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nMalejace:");
		
		//wypisz(quickSort.sort(dane.getMalejace()));
		startTime = System.nanoTime();
		quickSort.sort(dane.getMalejace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		
		System.out.println("\n\nheapSort");
		HeapSort heapSort = new HeapSort();	
		System.out.println("\nLosowe:");
		
		//wypisz(heapSort.sort(dane.getLosowe()));
		startTime = System.nanoTime();
		heapSort.sort(dane.getLosowe());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nRosnace:");
		
		//wypisz(heapSort.sort(dane.getRosnace()));
		startTime = System.nanoTime();
		heapSort.sort(dane.getRosnace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nMalejace:");
		
		//wypisz(heapSort.sort(dane.getMalejace()));
		startTime = System.nanoTime();
		heapSort.sort(dane.getMalejace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		
		System.out.println("\n\nmergeSort");
		MergeSort mergeSort = new MergeSort();	
		System.out.println("\nLosowe:");
		
		//wypisz(mergeSort.sort(dane.getLosowe()));
		startTime = System.nanoTime();
		mergeSort.sort(dane.getLosowe());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nRosnace:");
		
		//wypisz(mergeSort.sort(dane.getRosnace()));
		startTime = System.nanoTime();
		mergeSort.sort(dane.getRosnace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));
		
		System.out.println("\nMalejace:");
		
		//wypisz(mergeSort.sort(dane.getMalejace()));
		startTime = System.nanoTime();
		mergeSort.sort(dane.getMalejace());
		stopTime = System.nanoTime();
		System.out.println("Czas wykonania: "+(stopTime - startTime));

	}

}
