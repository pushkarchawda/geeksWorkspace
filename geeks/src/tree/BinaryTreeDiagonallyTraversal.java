package tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class BinaryTreeDiagonallyTraversal {
	Node root;
	TreeMap<Integer,ArrayList<Integer>> t = null;
	public static void main(String[] args) {
		BinaryTreeDiagonallyTraversal tree = new BinaryTreeDiagonallyTraversal();
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
		tree.t = new TreeMap<Integer,ArrayList<Integer>>(); 
		System.out.println("Left diagonal view traversal of binary tree - recursively is ");
		tree.printLeftDigonal(tree.root, 0);
		tree.print();
		tree.t = new TreeMap<Integer,ArrayList<Integer>>(); 
		System.out.println("right diagonal view traversal of binary tree - recursively is ");
		tree.printRightDigonal(tree.root, 0);
		tree.print();
	}
	
	private void printLeftDigonal(Node root, int VD) {
		if(root == null)
			return;
		ArrayList<Integer> a = t.get(VD);
		if(a == null)
			a = new ArrayList<>();
		a.add(root.d);
		t.put(VD, a);
		printLeftDigonal(root.left, VD);
		printLeftDigonal(root.right, VD+1);
	}

	private void printRightDigonal(Node root, int VD) {
		if(root == null)
			return;
		ArrayList<Integer> a = t.get(VD);
		if(a == null)
			a = new ArrayList<>();
		a.add(root.d);
		t.put(VD, a);
		printRightDigonal(root.left, VD+1);
		printRightDigonal(root.right, VD);
	}
	
	private void print() {
		for(ArrayList<Integer> j : t.values())
		{
			for(Integer i : j)
			{
				System.out.print(i+"->");
			}
			System.out.println();
		}
		System.out.println();
	}
}
