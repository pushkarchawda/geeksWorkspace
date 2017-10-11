package linkedlist_stack_queue;


public class MergeSortLL {

	Node head;

	public static void main(String[] args) {
		MergeSortLL llist = new MergeSortLL();

		/* Created Linked List 1->2->3->4->5 */
		llist.push(6);
		llist.push(4);
		llist.push(9);
		llist.push(2);
		llist.push(5);
		llist.push(0);

		System.out.println("Linked List before calling pairWiseSwap() ");
		llist.printList();

		llist.mergeSort(llist.head);

		System.out.println("Linked List after calling pairWiseSwap() ");
		llist.printList();

	}

	public Node mergeSort(Node head) {
		
		if(head == null || head.next == null)
			return head;
		
		Node headA = null, headB = null;
		Node dummyHead = head;
		Node middle = getMiddle(head);
		Node middleNext = middle.next;
		
		middle.next = null;
		
		headA = mergeSort(dummyHead);
		headB = mergeSort(middleNext);
		head = merge(headA, headB);
		
		return head;

	}
	
	private Node merge(Node dummyHead, Node middleNext) {

		if(dummyHead == null)
			return middleNext;
		
		if(middleNext == null)
			return dummyHead;
		
		Node current_head = null, current_current = null;
		
		if(dummyHead.data > middleNext.data)
		{	
			current_head = middleNext;
			//current_head.next = null;
			middleNext = middleNext.next;
		}
		else
		{
			current_head  = dummyHead;
			//current_head.next = null;
			dummyHead = dummyHead.next;
		}
			
		current_current = current_head;
		
		while(dummyHead != null && middleNext !=null)
		{
			
			if(dummyHead.data > middleNext.data)
			{
				current_current.next = middleNext;
				current_current = current_current.next;
				middleNext = middleNext.next;
			}
			else
			{
				current_current.next = dummyHead;
				current_current = current_current.next;
				dummyHead = dummyHead.next;
			}
			
		}
		
		while(middleNext != null)
		{
			//Dummy = head;
			current_current.next = middleNext;
			current_current = current_current.next;
			middleNext = middleNext.next;
		}
		
		while(dummyHead != null)
		{
			//Dummy = head;
			current_current.next = dummyHead;
			current_current = current_current.next;
			dummyHead = dummyHead.next;
		}
		
		return current_head;
	}

	public Node getMiddle(Node head) {
		
		Node slow = head, fast = head.next;
		
		if(head == null)
			return head;
		
		while(fast!=null && fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
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

}
