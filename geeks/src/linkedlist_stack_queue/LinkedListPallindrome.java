package linkedlist_stack_queue;
import linkedlist_stack_queue.Node;

public class LinkedListPallindrome {
	Node head;
	Node mid;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListPallindrome l = new LinkedListPallindrome();
		l.head = new Node(0);
		Node second = new Node(1);
		Node third = new Node(2);
		Node fourth = new Node(1);
		Node fifth = new Node(0);
		//Node sixth = new Node(0);
		
		l.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		//fifth.next = sixth;
		
		int count = 0;
		
		l.linkedListMid(l.head, count);
		
		l.reverseLinkedList(l.mid);
		
		boolean flag = false;
		
		if(count%2 == 0)
		{
			Node current = l.head;
			Node midCopy = l.mid;
			while(current!=null && midCopy !=null)
			{
				if(current.getData() == midCopy.getData())
				{
					flag = true;
				}
				else
				{
					flag = false;
					break;
				}
				current = current.getNext();
				midCopy = midCopy.getNext();
				
			}
		}
		else
		{
			Node current = l.head;
			Node midCopy = l.mid;
			while(midCopy !=null)
			{
				if(current.getData() == midCopy.getData())
				{
					flag = true;
				}
				else
				{
					flag = false;
					break;
				}
			}
		}
		
		if(flag)
			System.out.println("Pallindrome");
		else
			System.out.println("Not Pallindrome");
		

	}
	void reverseLinkedList(Node mid) {
		// TODO Auto-generated method stub
		if(mid == null)
			return;
		
		Node first = mid;
		Node last = mid.getNext();
		
		if(last == null)
			{
				this.mid = first;
				return;
			}
			
			reverseLinkedList(last);
			
			first.getNext().setNext(first);
			first.setNext(null);
		
		
		
		/*Node prev = null, next = null;
		Node current = mid;
		while(current!=null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		this.mid =  prev;
		*/
	}
	private void linkedListMid(Node head2,int count) {
		// TODO Auto-generated method stub
		mid = head2;
		Node current = head2;
		
		while(current!=null)
		{
			if(count%2== 1)
			{
				mid = mid.getNext();
			}
			
			count++;
			current = current.getNext();
		}
		
		System.out.println(mid.getData());
		
		//return mid;
	}

}
