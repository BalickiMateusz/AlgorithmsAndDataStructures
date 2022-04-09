package Lab9;

import java.util.ArrayList;

public class ExpressionTree {
	
	class Node{
		String value;
		Node left;
		Node right;
		Node(String a){
			value=a;
			left=null;
			right=null;
		}
		
		Node(String a, Node leftNode, Node rightNode){
			value = a;
			left = leftNode;
			right = rightNode;
		}
	}
	
	private ListStack<Node> stos;
	private ArrayList<String> operatory;
	private Node root;
	
	public ExpressionTree() {
		root=null;
		
		stos = new ListStack<Node>();
		operatory = new ArrayList <String>();
			
		operatory.add("(");
		operatory.add("+");
		operatory.add("-");
		operatory.add("*");
		operatory.add("/");
		operatory.add("%");
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		
		if(node!=null) {
			System.out.print("(");
			inOrder(node.left);		
			System.out.print(node.value);			
			inOrder(node.right);
			System.out.print(")");
		}
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node node) {
		
		if(node!=null) {
			postOrder(node.left);			
			postOrder(node.right);
			System.out.print(node.value+" ");
		}
	}
	
	public void Oblicz() {
		System.out.println("\n"+Oblicz(root));
	}
	
	private Double Oblicz(Node root) {
		 		  
	        if (root == null) {
	            return 0.0;
	        }
	 
	        else if (root.left==null && root.right==null) {
	            return Double.valueOf(root.value);
	        }
	        
	        double a = Oblicz(root.left);
	        double b = Oblicz(root.right);
	        
	        switch(root.value) {
	        
	        case "+":  
	        	return a + b; 
	        	
	        case "-": 
	        	return a - b; 
	        	
	        case "*": 
	        	return a * b;  
	        	
	        case "/":  
	        	return a / b; 
	        	
	        case "%":  
	        	return a % b; 
	        }
	        return 0.0;
	    }
	
	public void liczbaWezlow() {
		
		System.out.println(liczbaWezlow(root));	
	}
	
	private int liczbaWezlow(Node root) {	
		
		int liczba = 1;
		
		if(root==null) {
			return 0;
		}
		else {
			
			liczba+=liczbaWezlow(root.left);
			liczba+=liczbaWezlow(root.right);
			
			return liczba;
		}
	}
	
	public void liczbaLisci() {
		
		System.out.println(liczbaLisci(root));	
	}
	
	private int liczbaLisci(Node root) {	
		
		if(root==null) {
			return 0;
		}
		
		else if(root.left==null && root.right==null) {
			return 1;
		}
		
		else {				
			return liczbaLisci(root.left)+liczbaLisci(root.right);
		}
	}
	
	public void Wysokosc() {
		
		System.out.println(Wysokosc(root));	
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
	
	public Node wypelnijDrzewo(String napis) {
		
		String[] tokeny = napis.split("\\s+");	
		
		String token;
		Node t=null;
		
		try {					
			for(int i=0; i<tokeny.length; i++) {
				
				token = tokeny[i];
				if(operatory.contains(token)) {
					t = new Node(token);
					t.right=stos.pop();
					t.left=stos.pop();
					stos.push(t);
				}else if(token.length() >0 && Character.isDigit(token.charAt(0))) {													
					t = new Node(token);
					stos.push(t);
				}else {					
					System.out.println("Niepoprawne wyra¿enie!");
					t=null;
					throw new IllegalArgumentException();						
				}	
			}
			
			t=stos.top();
			stos.pop();
			return root=t;
			
		}catch(PustyStosException | IllegalArgumentException e) {
			e.printStackTrace();
			return root=t;
		}
	}
}
