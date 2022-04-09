package Lab11;

import java.util.ArrayList;
import java.util.Comparator;

public class RBTree<T> {
	
	private class Node{
		
		private T key;
		private ArrayList<Integer> lista;
		private Node left;
		private Node right;
		private Node parent;
		private boolean color;
		
		Node(T key, ArrayList<Integer> lista, Node left, Node right, Node parent, boolean color){
			
			this.key = key;
			this.lista = lista;
			this.left=left;
			this.right=right;
			this.parent=parent;
			this.color=color;
		}

		Node(T key, ArrayList<Integer> lista){
			
			this.key = key;
			this.lista = lista;
			this.left=null;
			this.right=null;
			this.parent=null;
			this.color=RED;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		@Override
		public String toString() {
		
			String napis = "Node [key="+key+ ", list="+lista.toString()+", left="+wypisz(left)+", right="+wypisz(right)+", parent="+wypisz(parent)+", color="+color+"]";
			return napis;
		}
		
		public String wypisz(Node node) {
			
			String napis;
			
			if(node!=null) {
				napis = "Node [key="+node.key+", lista="+node.lista.toString() + "color="+node.color+"]";
			}
			else {
				napis = "null";
			}
			
			return napis;
		}
		
	}
	
	private final boolean RED   = true;
    private final boolean BLACK = false;
	private final Comparator<T> comparator;	
	private Node root;
		
	public RBTree(Comparator<T> comparator) {	
		
		this.comparator=comparator;
		root=null;
	}
	
	public ArrayList<String> DrzewoAlfabetycznie() {
		
		ArrayList<String> alfabetycznie = new ArrayList<String>();
		UruchomInOrder(root, alfabetycznie);
		return alfabetycznie;
	}
	
	private void UruchomInOrder(Node node, ArrayList<String> alfabetycznie) {
		
		if(node != null) {
			
			UruchomInOrder(node.left, alfabetycznie);
			//System.out.println(node.key+"\t\t-\t"+node.lista.toString());
			String napis = String.format("%-15s %15s %15s", node.key, "-", node.lista.toString());
			alfabetycznie.add(napis);
			UruchomInOrder(node.right, alfabetycznie);
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
	
	/*public void WypiszWszerz2() {
		
		UruchomWypiszWszerz2(root);
	}
	
	private void UruchomWypiszWszerz2(Node node) {

		if((node == null)) {
			
			return;
		}		
		else if(node.left==null && node.right==null) {
			
			System.out.println(node);
		}
		else {
			
			UruchomWypiszWszerz2(node.left);
			UruchomWypiszWszerz2(node.right);
		}	
	}*/
	
	public void DodajNoda(T key, Integer wiersz) {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		lista.add(wiersz);
		
		Node node = new Node(key, lista);
		RBInsert(node);
	}
	
	private boolean TreeInsert(Node z) {
		
		Node y = null;
		Node x = root;
		boolean flag = true;
		
		while((x != null) && (flag==true)) {
			
			y = x;
			
			if(comparator.compare(z.key, x.key)<0) {
				
				x = x.left;
			}
			else if(comparator.compare(z.key, x.key)>0) {
				x = x.right;
			}
			else if(comparator.compare(z.key, x.key)==0) {
				
				//if(!x.lista.contains(z.lista.get(0))) {
					x.lista.add(z.lista.get(0));
				//}
				
				flag = false;
			}
		}
		
		if(flag == true) {

			z.parent = y;
			
			if(y == null) {
				this.root = z;
			}
			else if(comparator.compare(z.key, y.key)<0) {
				
				y.left = z;
			}
			else {
				
				y.right = z;
			}
		}
		return flag;
	}	
	
	private void RBInsert(Node x) {
		
		if(TreeInsert(x)==true) {
					
			Node y = null;
			x.color = RED;
			
			while((x != root) && (x.parent.color == RED)) {
				
				if(x.parent == x.parent.parent.left) {
					
					y = x.parent.parent.right;
					
					if((y!=null) && y.color == RED) {
						
						x.parent.color = BLACK;
						y.color = BLACK;
						x.parent.parent.color = RED;
						x = x.parent.parent;
					}	
					else {
						
						if(x == x.parent.right) {
							
							x = x.parent;						
							LeftRotate(x);
						}
						
						x.parent.color = BLACK;
						x.parent.parent.color = RED;
						RightRotate(x.parent.parent);
					}				
				}
				else {
					
					y = x.parent.parent.left;
					
					if((y!=null) && (y.color == RED)) {
						
						x.parent.color = BLACK;
						y.color = BLACK;
						x.parent.parent.color = RED;
						x = x.parent.parent;
					}	
					else {
						
						if(x == x.parent.left) {
							
							x = x.parent;						
							RightRotate(x);
						}
						
						x.parent.color = BLACK;
						x.parent.parent.color = RED;
						LeftRotate(x.parent.parent);
					}				
				}					
			}
			root.color = BLACK;	
		}
	}
	
	public Node Minimum(Node x) {
		
		while(x.left != null) {
			x = x.left;
		}
		
		return x;
	}
	
	public Node Nastepnik(Node x) {
		
		Node y = null;
		
		if(x.right != null) {
			return Minimum(x.right);
		}
		
		y=x.parent;
		
		while((y!=null) && (x==y.right)) {
			
			x=y;
			y=y.parent;
		}
		
		return y;
	}
	
	public void NaprawPoUsunieciu(Node x) {
		
		Node w = null;
		
		while((x!=root) && (x.color==BLACK)) {
			
			if(x==x.parent.left) {
				w = x.parent.right;
				
				if(w.color == RED) {
					
					w.color = BLACK;
					x.parent.color = RED;
					LeftRotate(x.parent);
					w=x.parent.right;
				}
				
				if((w.left.color == BLACK) && (w.right.color == BLACK)) {
					
					w.color = RED;
					x = x.parent;
				}
				else if(w.right.color == BLACK) {
					
					w.left.color = BLACK;
					w.color = RED;
					RightRotate(w);
					w = x.parent.right;
				}
				
				w.color = x.parent.color;
				x.parent.color = BLACK;
				w.right.color = BLACK;
				LeftRotate(x.parent);
				x = root;
			}
			else {
				w = x.parent.left;
				
				if(w.color == RED) {
					
					w.color = BLACK;
					x.parent.color = RED;
					LeftRotate(x.parent);
					w=x.parent.left;
				}
				
				if((w.right.color == BLACK) && (w.left.color == BLACK)) {
					
					w.color = RED;
					x = x.parent;
				}
				else if(w.left.color == BLACK) {
					
					w.right.color = BLACK;
					w.color = RED;
					LeftRotate(w);
					w = x.parent.left;
				}
				
				w.color = x.parent.color;
				x.parent.color = BLACK;
				w.left.color = BLACK;
				RightRotate(x.parent);
				x = root;
			}
			x.color = BLACK;
		}		
	}

	public Node RBDelete(Node z) {
		
		Node y = null;
		Node x = null;
		
		if((z.left==null) || (z.right==null)) {
			y=z;
		}
		else {
			y=Nastepnik(z);
		}
		
		if(y.left!=null) {
			x = y.left;
		}
		else {
			x = y.right;
		}
		
		if(x!=null) {
			x.parent = y.parent;
		}
		
		if(y.parent == null) {
			root = x;
		}
		else if(y == y.parent.left) {
			y.parent.left = x;
		}
		else {
			y.parent.right = x;
		}
		
		if(y!=z) {
			T keyz = z.key;
			ArrayList<Integer> listz = z.lista;
			
			z.key = y.key;
			z.lista = y.lista;
			
			y.key = keyz;
			y.lista = listz;
		}
		
		if(y.color == BLACK) {
			NaprawPoUsunieciu(x);
		}
		return y;
	}
	
	public void DeleteKey(T key) {
		
		Node x = StartSearch(root, key);
		System.out.println(x);
		RBDelete(x);
	}
	
	private Node StartSearch(Node x, T key) {
		
		if((x == null) || (comparator.compare(key, x.key)==0)) {
			
			return x;
		}
		
		if(comparator.compare(key, x.key)<0) {
			System.out.println("lewo");
			return StartSearch(x.left, key);
		}
		else {
			System.out.println("prawo");
			return StartSearch(x.right, key);
		}
	}
	
	private void LeftRotate(Node x) {
		
		Node y = x.right;
		x.right = y.left;
		
		if(y.left != null) {
			
			y.left.parent = x;
		}
		
		y.parent = x.parent;
		
		if(x.parent == null) {
			
			root = y;
		}
		else if(x == x.parent.left) {
			
			x.parent.left = y;
		}
		else {
			x.parent.right = y;
		}
		
		y.left = x;
		x.parent = y;
	}
	
	private void RightRotate(Node x) {
		
		Node y = x.left;
		x.left = y.right;
		
		if(y.right != null) {
			
			y.right.parent = x;
		}
		
		y.parent = x.parent;
		
		if(x.parent == null) {
			
			root = y;
		}
		else if(x == x.parent.left) {
			
			x.parent.left = y;
		}
		else {
			x.parent.right = y;
		}
		
		y.right = x;
		x.parent = y;
	}
	
}

