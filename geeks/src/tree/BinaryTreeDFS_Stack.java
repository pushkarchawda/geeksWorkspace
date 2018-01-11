package tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeDFS_Stack {

	Node root;

	public static void main(String[] args) {

		BinaryTreeDFS_Stack tree = new BinaryTreeDFS_Stack();
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

		System.out.println("Postorder traversal of binary tree using 2 stacks is ");
		tree.printPostorderTwoStacks(tree.root);
		System.out.println("Postorder traversal of binary tree using 1 stacks is ");
		tree.printPostorderOneStacks(tree.root); // reverse them later

		System.out.println("\nPreorder traversal of binary tree is ");
		tree.printPreorder(tree.root);
		
		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(tree.root);

	}

	private void printInorder(Node root) {

		Stack<Node> s1 = new Stack<Node>();
		// Stack s2 = new Stack<Node>();
		// ArrayList<Node> a = new ArrayList<Node>();
		if (root == null)
			return;

		Node current = root;
		// a.add(s1.pop());

		while (current != null) {
			s1.push(current);
			current = current.left;
		}

		while (!s1.isEmpty()) {
				Node temp = (Node) s1.pop();
				System.out.print(temp.d+"->");
				if (temp.right != null) {
				current = temp.right;
				while (current != null) {
					s1.push(current);
					current = current.left;
				}
			}
		}
		System.out.println();
	}

	private void printPreorder(Node root) {
		// TODO Auto-generated method stub
		Stack<Node> s1 = new Stack<Node>();
		// Stack s2 = new Stack<Node>();
		// ArrayList<Node> a = new ArrayList<Node>();
		if (root == null)
			return;

		s1.push(root);

		while (!s1.isEmpty()) {
			Node current = (Node) s1.pop();
			// a.add(s1.pop());

			if (current.right != null)
				s1.push(current.right);

			if (current.left != null)
				s1.push(current.left);

			// s.pop();
			System.out.print(current.d + "->");

		}
		System.out.println();
	}

	private void printPostorderOneStacks(Node root) {

		Stack<Node> s1 = new Stack<Node>();
		// Stack s2 = new Stack<Node>();
		// ArrayList<Node> a = new ArrayList<Node>();
		if (root == null)
			return;

		s1.push(root);

		while (!s1.isEmpty()) {
			Node current = (Node) s1.pop();
			// a.add(s1.pop());

			if (current.left != null)
				s1.push(current.left);

			if (current.right != null)
				s1.push(current.right);

			// s.pop();
			System.out.print(current.d + "->");

		}
		System.out.println();
	}

	private void printPostorderTwoStacks(Node root) {

		Stack s1 = new Stack<Node>();
		Stack s2 = new Stack<Node>();

		if (root == null)
			return;

		s1.push(root);

		while (!s1.isEmpty()) {
			Node current = (Node) s1.peek();
			s2.push(s1.pop());

			if (current.left != null)
				s1.push(current.left);

			if (current.right != null)
				s1.push(current.right);

			// s.pop();
		}

		while (!s2.isEmpty()) {
			Node current = (Node) s2.pop();
			System.out.print(current.d + "->");
		}
		System.out.println();

	}

}
