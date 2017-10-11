package tree;

import java.util.TreeMap;

public class BinaryTreeVerticalTraversal {

	Node root;
	TreeMap<Integer,Integer> t = null;

	public static void main(String[] args) {

		BinaryTreeVerticalTraversal tree = new BinaryTreeVerticalTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.t = new TreeMap<Integer,Integer>(); 
		System.out.println("Top view Vertical traversal of binary tree - recursively is ");
		tree.printtopVerticalorder(tree.root, 0);
		tree.print();
		tree.t = new TreeMap<Integer,Integer>(); 
		System.out.println("Bottom view Vertical traversal of binary tree - recursively is ");
		tree.printbottomVerticalorder(tree.root, 0);
		tree.print();
	}

	private void print() {

		for(Integer i : t.values())
		{
			System.out.print(i+"->");
		}
		System.out.println();
	}

	private void printbottomVerticalorder(Node root, int horizontalDistance) {

		if(root == null)
			return;
		
		t.put(horizontalDistance, root.d);
		
		printbottomVerticalorder(root.left, horizontalDistance-1);
		printbottomVerticalorder(root.right, horizontalDistance+1);
	
	}
	
	private void printtopVerticalorder(Node root, int horizontalDistance) {

		if(root == null)
			return;
		
		if(!t.containsKey(horizontalDistance))
		{
			t.put(horizontalDistance, root.d);
		}
		
		printtopVerticalorder(root.left, horizontalDistance-1);
		printtopVerticalorder(root.right, horizontalDistance+1);
	
	}

}
