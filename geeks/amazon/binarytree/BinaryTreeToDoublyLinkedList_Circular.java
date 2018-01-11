package binarytree;

import java.util.Stack;

/**
 * Convert a given Binary Tree to Doubly Linked List, convert it to a Doubly
 * Linked List(DLL). The left and right pointers in nodes are to be used as
 * previous and next pointers respectively in converted DLL. The order of nodes
 * in DLL must be same as Inorder of the given Binary Tree. The first node of
 * Inorder traversal (left most node in BT) must be head node of the DLL.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class BinaryTreeToDoublyLinkedList_Circular {

	Node root;
	static Node head;
	static Node tail;

	public static void main(String[] args) {

		BinaryTreeToDoublyLinkedList_Circular tree = new BinaryTreeToDoublyLinkedList_Circular();
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		printInOrder(tree.root);
		System.out.println();
		convert2DL(tree.root);

		System.out.println("Print Double Linked List ");

		Node current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.right;
			if (current != null)
				tail = current;
		}

		current = tail;
		System.out.println();
		System.out.println("Print Double Linked List reverse order ");

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.left;
		}

	}

	private static void convert2DL(Node root) {

		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();
		Node current = root;
		while (current != null) {
			s.add(current);
			current = current.left;
		}

		head = s.peek();
		s.peek().left = null;

		while (!s.isEmpty()) {
			Node temp = s.pop();
			// System.out.print(temp.data + " ");

			if (temp.right != null) {
				current = temp.right;
			}

			while (current != null) {
				s.add(current);
				// temp.right = current;
				current = current.left;

			}

			if (!s.isEmpty()) {
				temp.right = s.peek();
				s.peek().left = temp;
			}
			/*
			 * else // -- Uncomment this part to create a Circular Double Linked
			 * List { temp.right = head; head.left = temp; }
			 */
		}
	}

	private static void printInOrder(Node root) {

		if (root == null)
			return;

		Stack<Node> s = new Stack<Node>();

		Node current = root;

		while (current != null) {
			s.add(current);
			current = current.left;
		}

		while (!s.isEmpty()) {
			Node temp = s.pop();
			System.out.print(temp.data + " ");

			if (temp.right != null)
				current = temp.right;

			while (current != null) {
				s.add(current);
				current = current.left;
			}

		}
	}
}
