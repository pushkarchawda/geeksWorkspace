package linkedList;

class Node
{
	Node next;
	int data;
	
	Node(int d)
	{
		data = d;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

public class LinkedList {
	
	Node head;

	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		
		l.head = new Node(1);
		Node second = new Node(2);
		Node fourth = new Node(4);
		
		l.head.setNext(second);
		second.setNext(fourth);
		
		l.push(0);
		l.insertInBetween(3, 2);
		l.append(5);
		l.append(8);
		l.append(6);
		//l.print();
		l.delete(8);
		//l.reverseList();
		
		//l.firstLastRecursive(l.head);
		l.findNthElementFromLast(2);
		l.swapGivenNodes(3,8);
		l.print();
		
	}
	
	boolean swapGivenNodes(int i, int j)
	{
		Node swapNode1 = null, swapNode2 = null, current = head;
		Node prevNode1 = null, prevNode2 = null;
		
		if(head == null || i == j)
			return false;
		
		if(head.getData() == i)
			swapNode1 = head;
		
		if(head.getData() == j)
			swapNode2 = head;
		
		while(current.getNext()!=null)
		{
			if(current.getNext().getData() == i)
			{
				prevNode1 = current;
				swapNode1 = current.getNext();
			}
			if(current.getNext().getData() == j)
			{
				prevNode2 = current;
				swapNode2 = current.getNext();
			}
			
			current = current.getNext();
		}
		
		if(swapNode1 == null || swapNode2 == null)
			return false;
		
		if(prevNode1 != null)
			prevNode1.setNext(swapNode2);
		else
			head = swapNode2;
		
		if(prevNode2 != null)
			prevNode2.setNext(swapNode1);
		else
			head = swapNode1;
		
		Node temp = swapNode1.getNext();
		swapNode1.setNext(swapNode2.getNext());
		swapNode2.setNext(temp);
		
		return true;
		
	}
	
	void findNthElementFromLast(int n)
	{
		Node slow = head, fast = head;
		int x = n;
		
		while(x>0 && fast!=null)
		{
			fast = fast.getNext();
			x--;
		}
		
		while(fast!=null)
		{
			slow = slow.getNext();
			fast = fast.getNext();
		}
		
		System.out.println(n+"th Element from last : "+slow.getData());
	}
	
	void firstLastRecursive(Node n)
	{
		if(n == null)
			return;
		
		Node first = null, last = null;
		
		first = n;
		last = n.getNext();
		
		if(last == null)
			return;
		
		firstLastRecursive(last);
		
		first.getNext().setNext(first);
		first.setNext(null);
		
		head = last;
		
	}
	
	void reverseList()
	{
		Node current = head;
		Node prev = null, next = null;
		
		while(current!=null)
		{
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	int delete(int n)
	{
		int x = 0;
		
		if(head == null)
			return -1;
		
		if(head.getData() == n)
		{
			x = head.getData();
			head = head.getNext();
			return x;
		}
		
		Node current = head.getNext();
		Node prev = head;
		while(current!=null)
		{
			if(current.getData() == n)
			{
				x = current.getData();
				prev.setNext(current.getNext());
			}
			
			prev = current;
			current = current.getNext();
		}
		
		return x;
	}
	
	public void append(int n)
	{
		Node X = new Node(n);
		Node current = head;
		
		if(head == null)
		{
			head = X;
			return;
		}
		
		while(current.getNext()!=null)
			current = current.getNext();
		
		current.setNext(X);
		
	}
	
	public boolean insertInBetween(int insert, int insertAfter)
	{
		Node n = new Node(insert);
		Node current = null;
		boolean flag = false;
		
		if(head != null)
		{
			current = head;
		}
		
		while(current!=null)
		{
			if(current.getData() == insertAfter)
			{
				n.setNext(current.getNext());
				current.setNext(n);
				flag = true;
			}
			
			current = current.getNext();
		}
		
		return flag;
	}
	
	public void push(int n)
	{
		Node x = new Node(n);
		
		if(head == null)
		{
			head = x;
			return;
		}
		
		x.setNext(head);
		head = x;
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
