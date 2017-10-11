package linkedlist_stack_queue;

public class ReverseKAlternateNodes {
	Node head;

	public static void main(String[] args) {
		ReverseKAlternateNodes llist = new ReverseKAlternateNodes();
		 
        /* Created Linked List 1->2->3->4->5 */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        llist.push(0);
         
        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.printList();
         
        llist.head = llist.reverseInGrps(llist.head, 2);
         
        System.out.println("Linked List after calling pairWiseSwap() ");
        llist.printList();
        
	}
	
	private Node reverseInGrps(Node start, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		Node next = null, prev = null, current = start;
		while(count<k && current!=null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		start.next = current; 
		
		count = 0;
		while(count<k-1 && current!=null)
		{
			current = current.next;
			count++;
		}
		
		
		
		if(current!=null)
			current.next = reverseInGrps(current.next, k);
		
		return prev;
	}
	
	Node reverse(Node start, Node sPrev, int k)
	{
		Node next = null, prev = sPrev, current = start;
		int count = 0;
		while(current!=null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;

	}

	public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
  
        /* 3. Make next of new Node as head */
        new_node.next = head;
  
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
	
	 void printList()
	    {
	        Node temp = head;
	        while (temp != null)
	        {
	           System.out.print(temp.data+" ");
	           temp = temp.next;
	        }  
	        System.out.println();
	    }

}
