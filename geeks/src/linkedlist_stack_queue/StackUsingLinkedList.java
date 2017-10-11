package linkedlist_stack_queue;

import java.util.Scanner;

public class StackUsingLinkedList {
	
	int size;
	Node head;
	
	StackUsingLinkedList()
	{
		size = -1;
		head = null;
	}
	
	public boolean push(int d)
	{
		Node temp = new Node(d);
		if(head == null)
		{
			head = temp;
			size++;
			return true;
		}
		else if(head != null)
		{
			temp.setNext(head);
			head = temp;
			size++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Underflow Exception"); 
		}
		else
		{
			Node prev = head;
			head = head.getNext();
			size--;
			return prev.data;
		}
	}
	
	public int peek() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Underflow Exception"); 
		}
		else
		{
			return head.data;
		}
	}
	
	public void display()
	{
		System.out.println("Stack :");
		if(isEmpty())
			System.out.println("Stack is Empty");
		else
		{
			Node temp = head;
			while(temp != null)
			{
				System.out.println(temp.data);
				temp = temp.getNext();
			}
		}
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);   
        /* Creating object of class linkedStack */   
		StackUsingLinkedList ls = new StackUsingLinkedList();          
        /* Perform Stack Operations */  
        System.out.println("Linked Stack Test\n");  
        char ch;     
        do 
        {
            System.out.println("\nLinked Stack Operations");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");            
            int choice = scan.nextInt();
            switch (choice) 
            {
            case 1 :
                System.out.println("Enter integer element to push");
                ls.push( scan.nextInt() ); 
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Popped Element = "+ ls.pop());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ ls.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ ls.isEmpty());
                break;                
            case 5 : 
                System.out.println("Size = "+ ls.getSize()); 
                break;                
            case 6 : 
                System.out.println("Stack = "); 
                ls.display();
                break;                        
            default : 
                System.out.println("Wrong Entry \n ");
                break;
            }           
            /* display stack */    
            ls.display();            
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);       
 
        } while (ch == 'Y'|| ch == 'y'); 

	}

}

