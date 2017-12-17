package binarytree;

import java.lang.reflect.Array;

/**
 * Prefer - http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/
 * 
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * 
 * The diameter of a tree (sometimes called the width) is the number of nodes on
 * the longest path between two leaves in the tree. The diagram below shows two
 * trees each with diameter nine, the leaves that form the ends of a longest
 * path are shaded (note that there is more than one path in each tree of length
 * nine, but no path longer than nine nodes).
 * 
 * O(N)
 * 
 * @author PUSHKAR CHAWDA
 *
 */


public class DiameterPropertyBinaryTree {
	
	public Node root;

	public static void main(String[] args) throws CloneNotSupportedException {
		DiameterPropertyBinaryTree tree = new DiameterPropertyBinaryTree();
		/*tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);
		tree.root.left.left.left = new Node(1);
		tree.root.left.left.right = new Node(7);
		tree.root.left.right.right = new Node(15);
		tree.root.left.right.left = new Node(11);
		tree.root.left.right.left.right = new Node(4);
		tree.root.left.left.left.left = new Node(6);
		tree.root.left.right.left.left = new Node(9);*/
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(6);
		tree.root.left.right.left.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		//tree.root.left.left.left.right = new Node(8);
		//tree.root.left.left.left.right.right = new Node(8);
		//tree.root.left.left.left.right.right.right = new Node(8);
		 
		 

/* Constructed binary tree is
	    
		        10
		       /  \
		     8     2
		    / \   /
		  3    5 2
   		 / \  / \
   		1  7  11 15
   	   /       \
  	  6         4
  	  		   /
  	  		  9
 */
		
		System.out.println("Diameter : "+ getDiameter(tree.root)[1]);
	

	}

	private static int[] getDiameter(Node root) {
		
		int HeightDiameter[] = new int[]{0,0}; // {height, diameter}
		
		if(root == null)
			return HeightDiameter;

		int left[] = getDiameter(root.left);
		int right[] = getDiameter(root.right);
		
		int leftDiameter = left[1];
		int rightDiameter = right[1];
		int rootDiameter = left[0]+right[0]+1;
		
		int finalDiameter = getMax(leftDiameter, rightDiameter, rootDiameter);
		
		HeightDiameter[0] = Math.max(left[0], right[0])+1;
		HeightDiameter[1] = finalDiameter;
		
		return HeightDiameter;

	}
	
	private static int getMax(int a, int b, int c)
	{
		return Math.max(a, Math.max(b, c));
	}
}
