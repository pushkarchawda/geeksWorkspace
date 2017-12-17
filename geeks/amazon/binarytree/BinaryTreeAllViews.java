package binarytree;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Binary tree traversal questions like 
 * left view, 
 * right view, 
 * top view, 
 * bottom view, 
 * maximum of a level, 
 * minimum of a level, 
 * 
 * @author PUSHKAR CHAWDA
 *
 */


public class BinaryTreeAllViews {
	
	static TreeMap<Integer, Integer> tmView = null;
	public Node root;

	public static void main(String[] args) {
		BinaryTreeAllViews tree = new BinaryTreeAllViews();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(2);

/* Constructed binary tree is
	    
        10
       /  \
     8     2
    / \   /
   3   5 2
  
 */

		tmView = new TreeMap<>();
		topView(tree.root, 0);
		print();
		tmView.clear();
		bottomView(tree.root, 0);
		print();
		tmView.clear();
		rightView(tree.root, 0);
		print();
		tmView.clear();
		leftView(tree.root, 0);
		print();
		
		int maxLevel = maxLevel(tree.root);
		System.out.println("Max Level "+maxLevel);
		
		int minLevel = minLevel(tree.root);
		System.out.println("Min Level "+minLevel);
		
	}

	

	private static int maxLevel(Node root) {

		if(root == null)
			return -1;
		
		int left = maxLevel(root.left);
		int right = maxLevel(root.right);
		
		if(left>right)
			return left+1;
		else
			return right+1;
	}
	
	private static int minLevel(Node root) {

		if(root == null)
			return -1;
		
		int left = maxLevel(root.left);
		int right = maxLevel(root.right);
		
		if(left<right)
			return left+1;
		else
			return right+1;
	}

	private static void leftView(Node root, int vertDist) {

		if (root == null)
			return;

		tmView.put(vertDist, root.data);
		leftView(root.right, vertDist + 1);
		leftView(root.left, vertDist + 1);
	}

	private static void rightView(Node root, int vertDist) {

		if (root == null)
			return;

		tmView.put(vertDist, root.data);
		rightView(root.left, vertDist + 1);
		rightView(root.right, vertDist + 1);
	}

	private static void print() {

		Iterator<Entry<Integer, Integer>> it = tmView.entrySet().iterator();

		while (it.hasNext()) {
			System.out.print(it.next().getValue() + " ");
		}
		System.out.println();
	}

	private static void topView(Node root, int horizDist) {

		if (root == null)
			return;

		if (!tmView.containsKey(horizDist)) {
			tmView.put(horizDist, root.data);
		}
		topView(root.left, horizDist - 1);
		topView(root.right, horizDist + 1);
	}

	private static void bottomView(Node root, int horizDist) {

		if (root == null)
			return;

		tmView.put(horizDist, root.data);
		bottomView(root.left, horizDist - 1);
		bottomView(root.right, horizDist + 1);
	}

}
