package binarytree;

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
 * O(N^2)
 * 
 * @author PUSHKAR CHAWDA
 *
 */


public class Naive_DiameterPropertyBinaryTree {
	
	public Node root;

	public static void main(String[] args) throws CloneNotSupportedException {
		Naive_DiameterPropertyBinaryTree tree = new Naive_DiameterPropertyBinaryTree();
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
		
		System.out.println("Diameter : "+getDiameter(tree.root));
	

	}

	private static int getDiameter(Node root) {
		
		if(root == null)
			return 0;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		int leftDiameter = getDiameter(root.left);
		int rightDiameter = getDiameter(root.right);
		
		return getMax(1+leftHeight+rightHeight, leftDiameter, rightDiameter);
		

	}
	
	private static int getMax(int a, int b, int c)
	{
		return Math.max(a, Math.max(b, c));
	}
	
	private static int getHeight(Node root){
		
		if(root == null)
			return 0;
		
		return 1+Math.max(getHeight(root.left), getHeight(root.right));
	}
}
