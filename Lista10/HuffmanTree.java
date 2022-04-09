package Lab10;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
	
	class FrequencyComparator implements Comparator<Node> {
	    public int compare(Node a, Node b)
	    {
	    	int wynik = b.frequency - a.frequency;
	    	
	    	if(wynik==0) {
	    		
	    		wynik = getChildren(b) - getChildren(a) ;
	    	
	    	}
	    	
	    return wynik;
	    	
	    }
	}
	
	class Node{
		
		int frequency;
		String znak;
		Node left;
		Node right;
		
		Node(int frequency){
			
			this.frequency = frequency;
			left=null;
			right=null;
		}
		
		Node(int frequency, String znak){
			
			this.frequency = frequency;
			this.znak = znak;
			left=null;
			right=null;
		}
		
		Node(int frequency, String znak, Node leftNode, Node rightNode){
			
			this.frequency = frequency;
			this.znak = znak;
			left = leftNode;
			right = rightNode;
		}
		
		@Override
		public String toString() {
		
			return znak+" "+frequency;
		}
	}
	
	private LinkedHashMap<String, Integer> mapa;
	private PriorityQueueHeap<Node> priorityQueue;	
	private Node root;
	private LinkedHashMap<String, String> kody = new LinkedHashMap<String, String>();
	
	public HuffmanTree(LinkedHashMap<String, Integer> mapa) {	
		
		root=null;
		priorityQueue = new PriorityQueueHeap<>(new FrequencyComparator());
		this.mapa = mapa;
	}
	
	public void BuildTree() {
		      
        List<String> lista = new ArrayList<String>(mapa.keySet());
        
        Collections.reverse(lista);
        
		for(int i=0; i<lista.size(); i++) {
			
			Node node = new Node(mapa.get(lista.get(i)), lista.get(i), null, null);
			priorityQueue.enqueue(node);
		}
		while(priorityQueue.size()>1) {
			
			try {
				
			Node minNodeA = priorityQueue.dequeue();
			Node minNodeB = priorityQueue.dequeue();
				
			Node minNodeAB = new Node(minNodeA.frequency+minNodeB.frequency);
	
			minNodeAB.left = minNodeA;
			minNodeAB.right = minNodeB;
			
			root = minNodeAB;
			
			priorityQueue.enqueue(minNodeAB);
				 
			}catch(EmptyQueueException e) {
				
				e.printStackTrace();
			}
			
		}
		System.out.println("Utworzono drzewo Huffmana!");
	}
	
	public LinkedHashMap<String, String> kodyZnaków()
    {
		kodyZnaków(root, "", kody);
		System.out.println("\nWygenerowano kod:");
		return kody;
    }
	
	private void kodyZnaków(Node node, String kod, LinkedHashMap<String, String> kody)
    {	
		
			
        if (node.left == null && node.right == null) {
           // System.out.println(node.znak + ":" + kod);
            kody.put(node.znak, kod);
            return;
        }
        
        kodyZnaków(node.left, kod + "0", kody);
        kodyZnaków(node.right, kod + "1", kody);
    }
	
	public int getChildren(Node node) {
		
		if(node.left==null && node.right==null) {
			return 0;
		}
		else if(node.left==null || node.right==null) {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	private int Wysokosc(Node root) {	
		
		if(root==null) {
			return -1;
		}
		
		int l = Wysokosc(root.left);
		int r = Wysokosc(root.right);
		
		if(l>r) {
			return l+1;
		}else {
			return r+1;
		}
	}
	
	public void WypiszWszerz() {
		int wysokosc = Wysokosc(root);
		
		for(int i = 0; i <= wysokosc; i++) {
			
			System.out.println("Wysokosc: "+i);
			WypiszPoziom(root, i);
		}
		
	}
	
	private void WypiszPoziom(Node node, int poziom) {
		
		if((node == null) || (poziom < 0)) {
			
			return;
		}		
		else if(poziom == 0) {
			
			System.out.println(node);
		}
		else if(poziom >0) {
			
			WypiszPoziom(node.left, poziom-1);
			WypiszPoziom(node.right, poziom-1);
		}	
	}
}
