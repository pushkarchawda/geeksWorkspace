package linkedlist_stack_queue;

public class LinkedList_Reverse {
	
	Node head;
	
	public static void main(String[] args) {

		LinkedList_Reverse g = new LinkedList_Reverse();
		g.push(0);
		g.push(1);
		g.push(2);
		g.push(4);
		g.push(5);
		g.push(6);
		g.push(7);
		//g.display();
		System.out.println("*******");
		g.display();
		System.out.println("*******");
		//g.reverse();
		//g.display();
		System.out.println("*******");
		//g.head = g.reverseRecursion(g.head, null);
		//g.display();
		System.out.println("*******");
		g.reverseRecursionFirstLast(g.head);
		g.display();
		
	}
	
	public void reverse()
	{
		Node prev = null, next = null;
		Node current = head;
		while(current!=null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	public Node reverseRecursion(Node current, Node prev)
	{
		if(current==null)
			return prev;
		
		Node next = current.getNext();
		current.setNext(prev);
		prev = reverseRecursion(next, current);
		
		
		return prev;
	}
	
	public void reverseRecursionFirstLast(Node current)
	{
		if(current == null)
			return;
		
		Node first = null, rest = null;
		
		first = current;
		rest = current.getNext();
		
		if(rest == null)// try removing
		{
			head = first;
			return;		// try removing
		}
			
		reverseRecursionFirstLast(rest);
		
		first.getNext().setNext(first);
		first.setNext(null);
		
		
		
	}
	
	class Node {

		int data;
		Node next;

		Node(int d) {

			data = d;
			next = null;

		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
	
	void display() {
		Node current = head;
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	
	}
	
	boolean push(int d) {
		Node temp = new Node(d);
		if (head == null) {
			head = temp;
			return true;
		} else if (head != null) {
			temp.setNext(head);
			head = temp;
			return true;
		} else
			return false;

	}

}
