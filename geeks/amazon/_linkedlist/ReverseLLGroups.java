package _linkedlist;

public class ReverseLLGroups {

	Node head;
	public static void main(String args[]) {
		ReverseLLGroups ll = new ReverseLLGroups();
		ll.pushLL(1);
		ll.pushLL(2);
		ll.pushLL(3);
		ll.pushLL(4);
		ll.pushLL(5);
		ll.pushLL(6);
		ll.pushLL(7);
		ll.pushLL(8);
		System.out.println("Before Reverse : ");
		ll.print();
		ll.head = ll.reverseInGrp(ll.head, 3);
		System.out.println("After Reverse : ");
		ll.print();
	}

	private void print() {
		
		Node current = head;
		
		while(current!=null)
		{
			System.out.print(current.data);
			current = current.next;
		}
		System.out.println();
	}

	private Node reverseInGrp(Node root, int k) {

		Node prev = null, next = null, current = root;
		int count = 1;
		while (current != null && count <= k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if(current!=null)
		root.next = reverseInGrp(current, 3);

		return prev;
	}

	private void pushLL(int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

}
