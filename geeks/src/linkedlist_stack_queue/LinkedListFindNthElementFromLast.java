package linkedlist_stack_queue;

public class LinkedListFindNthElementFromLast {
	
	Node head;
	
	public static void main(String[] args) {

		LinkedListFindNthElementFromLast g = new LinkedListFindNthElementFromLast();
		g.push(0);
		g.push(1);
		g.push(2);
		g.push(4);
		g.push(5);
		g.push(6);
		g.push(7);
		System.out.println("*******");
		g.display();
		System.out.println("*******");
		int d = g.findNthElementFromLast(g.head, 3);
		System.out.println(" Nth Element From Last "+d);
		
		
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
	
	public int findNthElementFromLast(Node current, int n)
	{
		Node temp = current;
		boolean reachNthFromStart = false;
		int count = 1;
		
		while(current!=null)
		{
			if(count == n)
				reachNthFromStart = true;
			
			if(reachNthFromStart && current.getNext()!=null)
				temp = temp.getNext();
			
			count++;
			current = current.getNext();
		}
		
		return temp.getData();
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
