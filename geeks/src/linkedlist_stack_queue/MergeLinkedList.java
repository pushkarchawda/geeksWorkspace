package linkedlist_stack_queue;


class MergeLinkedList {

	Node headA;
	Node head;
	Node headB;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeLinkedList g = new MergeLinkedList();
		g.pushA(7);
		g.pushA(5);
		g.pushA(3);
		g.pushA(1);
		
		g.displayA();
		
		g.pushB(6);
		g.pushB(4);
		g.pushB(2);		
		g.displayB();
		
		g.merge(g.headA, g.headB);
		
		Node current = g.head;
		while (current != null) {
			System.out.print(current.getData()+" ");
			current = current.getNext();
		}
		System.out.println();
		
		

	}
	
	void merge(Node a, Node b)
	{
		Node dummy = null;
		if(a.getData() > b.getData())
		{
			dummy = b;
			head = dummy;
			b = b.getNext();
			
		}
		else
		{
			dummy = a;
			head = dummy;
			a = a.getNext();
		}
		
		while(a!=null && b!=null)
		{
			if(a.getData() > b.getData())
			{
				dummy.setNext(b);
				dummy = dummy.getNext();
				b = b.getNext();
				
			}
			else
			{
				dummy.setNext(a);
				dummy = dummy.getNext();
				a = a.getNext();
			}
		}
		
		while(a!=null)
		{
			dummy.setNext(a);
			dummy = dummy.getNext();
			a = a.getNext();
		}
		
		while(b!=null)
		{
			dummy.setNext(b);
			dummy = dummy.getNext();
			b = b.getNext();
		}
		
	}
	
	void displayA() {
		Node current = headA;
		while (current != null) {
			System.out.print(current.getData()+" ");
			current = current.getNext();
		}
		System.out.println();
		
	}
		void displayB() {
			Node current = headB;
			while (current != null) {
				System.out.print(current.getData()+" ");
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
