package linkedlist_stack_queue;

public class SegregateEvenOddNodes {
	
	Node head;
	Node odd;

	public static void main(String[] args) {
		SegregateEvenOddNodes llist = new SegregateEvenOddNodes();

		/* Created Linked List 1->2->3->4->5 */
		llist.push(6);
		llist.push(1);
		llist.push(4);
		llist.push(9);
		llist.push(2);
		llist.push(5);
		llist.push(0);

		System.out.println("Linked List before calling segregateNode() ");
		llist.printList();

		llist.segregateNode();

		System.out.println("Linked List after calling segregateNode() ");
		
		llist.printList(llist.odd);

	}
	
	private void segregateNode() {
		Node  current = head, prev = null, oddTemp = null;
		boolean flag = false;
		
		while(current!=null)
		{
			if(current.data % 2 != 0)
			{
				odd = head;
				oddTemp = odd;
				head = head.next;
				flag = true;
			}
			if(flag)
			break;
		}
		
		current = head;
		
		while(current!=null && flag)
		{
			
			if((current.data) % 2 != 0)
			{
					oddTemp.next = current;
					oddTemp = oddTemp.next;
					prev.next = current.next;
			}
			prev = current;
			current = current.next;
		}
		
		printList();
	}

	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	void printList(Node odd) {
		Node temp = odd;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
