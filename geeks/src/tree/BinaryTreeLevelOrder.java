package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrder {

	Node root;

	public static void main(String[] args) {

		BinaryTreeLevelOrder tree = new BinaryTreeLevelOrder();
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

		System.out.println("Level Order traversal of binary tree - recursively is ");
		tree.printLevelorder(tree.root);
		
		
		System.out.println("Level Order traversal of binary tree - queue is ");
		tree.printLevelorderQueue(tree.root);
		

	}

	private void printLevelorderQueue(Node root) {

		if(root == null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		
		while(!q.isEmpty())
		{
			Node current = q.poll();
			System.out.print(current.d+"->");
			
			if(current.left != null)
				q.add(current.left);
			
			if(current.right != null)
				q.add(current.right);
			
		}
		
	}

	private void printLevelorder(Node root) {

		int h = findHeight(root);
		//System.out.println(h);
		for(int i = 0; i<=h;i++)
		{
			printLevelOrder(root, i, h);
			System.out.println();
		}
	}

	private void printLevelOrder(Node root, int i, int h) {

		if(root == null)
			return;
		
		if(i == h)
			System.out.print(root.d+"->");
		
		printLevelOrder(root.left, i, h-1);
		printLevelOrder(root.right, i, h-1);
		
	}

	private int findHeight(Node root) {

		if(root == null)
			return 0;
		
		int lHeight = findHeight(root.left)+1;
		int rHeight = findHeight(root.right)+1;
		
		if(lHeight > rHeight)
			return rHeight;
		else
			return lHeight;
				
	}

}
