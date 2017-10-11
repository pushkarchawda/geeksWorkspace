package linkedlist_stack_queue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class DetectIntersectionPointLinkedList {

	Node headA;
	Node head;
	Node headB;

	public static void main(String[] args) {

		DetectIntersectionPointLinkedList g = new DetectIntersectionPointLinkedList();
		g.pushA(7);
		g.pushA(5);
		g.pushA(3);
		g.pushA(1);

		g.displayA();

		g.pushB(6);
		g.pushB(4);
		g.pushB(2);
		g.displayB();

		System.out.println();

		Node current = g.headA;
		while (current.getNext() != null) {
			current = current.getNext();
		}

		Node temp = new Node(0);
		current.setNext(temp);

		current = g.headB;
		while (current.getNext() != null) {
			current = current.getNext();
		}

		current.setNext(temp);

		current = g.headA;

		HashSet<Node> t = new HashSet<>();

		while (current != null)
		{
			t.add(current);
			current = current.getNext();
		}
			

		current = g.headB;

		while (current != null) {
			if (!t.add(current)) {
				System.out.println("Intersection !!");
				System.out.println("Point " + current.getData());
			}
			current = current.getNext();
		}
	}

	void displayA() {
		Node current = headA;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		System.out.println();

	}

	void displayB() {
		Node current = headB;
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		System.out.println();
	}

	boolean pushA(int d) {
		Node temp = new Node(d);
		if (headA == null) {
			headA = temp;
			return true;
		} else if (headA != null) {
			temp.setNext(headA);
			headA = temp;
			return true;
		} else
			return false;

	}

	boolean pushB(int d) {
		Node temp = new Node(d);
		if (headB == null) {
			headB = temp;
			return true;
		} else if (headB != null) {
			temp.setNext(headB);
			headB = temp;
			return true;
		} else
			return false;

	}
}
