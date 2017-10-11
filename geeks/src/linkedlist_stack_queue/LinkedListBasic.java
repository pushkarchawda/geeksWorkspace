package linkedlist_stack_queue;

public class LinkedListBasic {

	Node head;
	
	static class Node
	{
		int data;
		Node next;
		
		Node(int d){ data = d;}
	}
	
	public static void main(String[] args) {
		
		LinkedListBasic l = new LinkedListBasic();
		l.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		
		l.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		
		Node current = l.head;
		
		while(current!=null)
		{
			System.out.println(current.data);
			current = current.next; 
		}
		
		

	}

}
