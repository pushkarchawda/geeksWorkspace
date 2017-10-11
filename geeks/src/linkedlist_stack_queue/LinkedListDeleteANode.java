package linkedlist_stack_queue;


public class LinkedListDeleteANode {
	
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
		}
	}

	void push() {

		Node zeroth = new Node(0);
		zeroth.next = head;
		head = zeroth;

	}

	void insertAfter(int afterData, Node seventh) {


		Node temp = head;

		while (temp != null) {
			if (temp.data == afterData) {
				seventh.next = temp.next;
				temp.next = seventh;
			}
			temp = temp.next;
		}

	}

	public static void main(String[] args) {

		LinkedListDeleteANode l = new LinkedListDeleteANode();
		l.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node eigth = new Node(8);
		
		Node seventh = new Node(7);

		l.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = eigth;
		
		l.push();
		l.insertAfter(6, seventh);
		
		l.delete(4);

		Node current = l.head;

		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	private void delete(int i) {
		
		Node current = head;
		Node prev = null;
		while(current.next!=null)
		{
			prev = current;
			if(current.data == i)
				break;
			current = current.next;
		}
		
		
		
	}

}
