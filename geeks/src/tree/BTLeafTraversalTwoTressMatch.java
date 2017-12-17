package tree;

import java.util.Stack;

/*
 * Check if leaf traversal of two Binary Trees is same?
   Leaf traversal is sequence of leaves traversed from left to right. 
   The problem is to check if leaf traversals of two given Binary Trees are same or not.
   Expected time complexity O(n). Expected auxiliary space O(h1 + h2) where h1 and h2 are heights of two Binary Trees.
 * */

public class BTLeafTraversalTwoTressMatch {

	Node root1;
	Node root2;

	public static void main(String[] args) {

		BTLeafTraversalTwoTressMatch tree = new BTLeafTraversalTwoTressMatch();
		tree.root1 = new Node(1);
		tree.root1.left = new Node(2);
		tree.root1.right = new Node(3);
		tree.root1.left.left = new Node(4);
		tree.root1.left.right = new Node(5);
		/*
		 * tree.root1.right.left = new Node(6); tree.root1.right.right = new
		 * Node(7); tree.root1.left.left.left = new Node(8);
		 * tree.root1.left.left.right = new Node(9); tree.root1.left.right.left
		 * = new Node(10);
		 */

		tree.root2 = new Node(1);
		tree.root2.left = new Node(2);
		tree.root2.right = new Node(3);
		tree.root2.left.left = new Node(4);
		tree.root2.left.right = new Node(5);
		/*
		 * tree.root2.right.left = new Node(6); tree.root2.right.right = new
		 * Node(7); tree.root2.left.left.left = new Node(8);
		 * tree.root2.left.left.right = new Node(9); tree.root2.left.right.left
		 * = new Node(10);
		 */

		System.out.println("Check if leaf traversal of two Binary Trees is same - "
				+ tree.checkLeafTwoTree(tree.root1, tree.root2, 0));

	}

	private boolean checkLeafTwoTree(Node root1, Node root2, int i) {

		if (root1 == null && root2 != null)
			return false;
		if (root1 != null && root2 == null)
			return false;
		if (root1 == null && root2 == null)
			return false;

		Stack<Node> q1 = new Stack<Node>();
		Stack<Node> q2 = new Stack<Node>();

		q1.push(root1);
		q2.push(root2);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			if (q1.isEmpty() && q2.isEmpty())
				return false;

			Node temp1 = (Node) q1.pop();
			while (temp1 != null && !temp1.isLeaf()) {
				if (temp1.right != null) {
					q1.push(temp1);
				}
				if (temp1.left != null) {
					q1.push(temp1);
				}

				temp1 = (Node) q1.pop();
			}

			Node temp2 = (Node) q2.pop();
			while (temp2 != null && temp2.isLeaf()) {
				if (temp2.right != null)
					q2.push(temp1);
				if (temp2.left != null)
					q2.push(temp1);

				temp2 = (Node)q2.pop();
			}

			if (temp1 == null && temp2 != null)
				return false;
			if (temp2 == null && temp1 != null)
				return false;

			if (temp1 != null && temp2 != null) {
				if (temp1.d != temp2.d)
					return false;
			}
		}
		return true;
	}

}
