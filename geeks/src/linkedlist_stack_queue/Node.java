package linkedlist_stack_queue;

public class Node
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
