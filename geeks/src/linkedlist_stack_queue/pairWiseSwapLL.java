package linkedlist_stack_queue;

public class pairWiseSwapLL {
	
	Node head;

	public static void main(String[] args) {
		pairWiseSwapLL llist = new pairWiseSwapLL();
		 
        /* Created Linked List 1->2->3->4->5 */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
         
        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.printList();
         
        llist.pairWiseSwap();
         
        System.out.println("Linked List after calling pairWiseSwap() ");
        llist.printList();
        
	}
	
	private void pairWiseSwap() {
		// TODO Auto-generated method stub
		Node current = null;
		current = head;
		while(current!=null && current.next!=null)
		{
			
			int temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
			current  = current.next.next;
		}
		
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
