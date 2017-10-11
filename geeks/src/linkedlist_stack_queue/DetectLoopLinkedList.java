package linkedlist_stack_queue;

public class DetectLoopLinkedList {

	Node head;

	public static void main(String[] args) {
		
		DetectLoopLinkedList l = new DetectLoopLinkedList();
		
		l.head = new Node(1);
		Node second = new Node(2);
		Node fourth = new Node(4);
		
		l.head.setNext(second);
		second.setNext(fourth);
		fourth.setNext(l.head);
		
		Node slow = l.head;
		Node fast = l.head;
		
		
		while(slow!=null && fast!=null)
		{
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast)
			{
				System.out.println("!!!! LOOP !!!");
				return;
			}
		}
		
		/*if(slow == fast)
			System.out.println("!!!! LOOP !!!");*/
		
		//l.print();
		
	}
	
	public void print()
	{
		Node current = head;
		while(current!=null)
		{
			System.out.println(current.getData());
			current = current.getNext();
		}
	}

}
