package linkedlist_stack_queue;

public class LinkedListInsertNode3Ways {

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
		
		Node seventh1 = new Node(7);

		while (temp != null) {
			if (temp.data == afterData) {
				seventh1.next = temp.next;
				temp.next = seventh1;
			}
			temp = temp.next;
		}

	}

	public static void main(String[] args) {

		LinkedListInsertNode3Ways l = new LinkedListInsertNode3Ways();
		l.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node eigth = new Node(8);
		
		Node seventh = new Node(7);
		
		Node latest = new Node(9);

		l.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = eigth;
		
		l.push();
		l.insertAfter(6, seventh);
		l.append(latest);

		Node current = l.head;

		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	private void append(Node latest) {

		
		
		if(head==null)
			head = latest;
			
		
		Node temp = head;
		
		
		
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		
			temp.next = latest;
	}
}
