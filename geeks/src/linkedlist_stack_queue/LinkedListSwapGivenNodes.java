package linkedlist_stack_queue;

public class LinkedListSwapGivenNodes {

	public static void main(String[] args) {

		LinkedListSwapGivenNodes f = new LinkedListSwapGivenNodes();
		DeleteNode g = f.new DeleteNode();
		g.push(0);
		g.push(1);
		g.push(2);
		g.push(4);
		g.push(5);
		g.push(6);
		g.push(7);
		g.insertAfter(3, 4);
		g.append(-1);
		g.append(-2);

		g.display();

		System.out.println("*******");
		g.delete(6);

		g.display();
		System.out.println("*******");
		g.swapNodes(7, -2);
		g.display();
		System.out.println("*******");
	}

	class DeleteNode {

		Node head;

		boolean push(int d) {
			Node temp = new Node(d);
			// System.out.println("temp "+temp.getData());
			if (head == null) {
				head = temp;
				return true;
			} else if (head != null) {
				temp.setNext(head);
				head = temp;
				return true;
			} else
				return false;

		}

		boolean insertAfter(int d, int valueAfterToInsert) {
			Node temp = new Node(d);

			Node current = head;

			while (current != null) {
				if (current.getData() == valueAfterToInsert) {
					temp.setNext(current.getNext());
					current.setNext(temp);
					return true;
				}
				current = current.getNext();
			}

			return false;
		}

		boolean append(int d) {
			Node temp = new Node(d);

			Node current = head;

			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(temp);
			return true;
		}

		int delete(int key) {
			if (head.getData() == key) {
				int t = head.getData();
				head = head.getNext();
				return t;
			}

			Node current = head;
			Node prev = head;
			while (current != null) {
				if (current.getData() == key) {
					int t = current.getData();
					prev.setNext(current.getNext());
					return t;
				}
				prev = current;
				current = current.getNext();
			}

			return Integer.MIN_VALUE;
		}

		void display() {
			Node current = head;
			while (current != null) {
				System.out.println(current.getData());
				current = current.getNext();
			}
		}
		
		void swapNodes(int x, int y)
		{
			Node current = head;
			Node prevX = null, prevY = null;
			boolean flagX = true, flagY  = true, flagX1 = true, flagY1  = true;
			
			if(current.data == x)
			{
				prevX = current;
				flagX1 = false;
				//flagX = false;
			}
			
			if(current.data == y)
			{
				prevY = current;
				flagY1 = false;
				//flagY = false;
			}
			
			
			do
			{
				if(current.getNext().getData() == x && flagX)
				{
					prevX = current;
					flagX = false;
				}
				
				if(current.getNext().getData() == y && flagY)
				{
					prevY = current;
					flagY = false;
				}
				
				current = current.getNext();
			}while(current.getNext() != null);
			System.out.println("*******"+prevX.data);
			System.out.println("*******"+prevY.data);
			
			if(!flagX && ! flagY)
			{
				Node tempX = prevX.getNext();
				Node tempY = prevY.getNext();
				prevX.setNext(tempY);
				prevY.setNext(tempX);
				prevX.getNext().setNext(prevY.getNext().getNext());
				prevY.getNext().setNext(prevX);
			}
			else if(!flagX1)
			{
				Node tempX = prevX.getNext();
				Node tempY = prevY.getNext();
				prevY.setNext(prevX);
				prevX.setNext(tempY.getNext());
				//prevX.getNext().setNext(prevY.getNext().getNext());
				tempY.setNext(tempX);
				head = tempY;
			}
			else if(!flagY1)
			{
				Node tempX = prevX.getNext();
				Node tempY = prevY.getNext();
				prevX.setNext(prevY);
				prevY.setNext(tempX.getNext());
				//prevX.getNext().setNext(prevY.getNext().getNext());
				tempX.setNext(tempY);
				head = tempX;
			}
			
			/*if(head.getData() == x)
			{
				tempX = head.getNext();
			}3
			
			if(head.getData() == y)
			{
				tempX = head.getNext();
			}
			
			while(current.getNext()!=null)
			{
				if(current.getNext().getData() == x && flagX)
				{
					prevX = current;
					flagX = false;
				}
				
				if(current.getNext().getData() == y && flagY)
				{
					prevY = current;
					flagY = false;
				}
				
				current = current.getNext();
			}
			
			prevX.setNext(prevY.getNext());
			prevY.setNext(prevX.getNext());
			
			if(prevX.getNext()!=null)
				prevX.getNext().setNext(prevY.getNext());
			if(prevY.getNext()!=null)
			prevY.getNext().setNext(prevX.getNext());*/
		}
	}

	class Node {

		int data;
		Node next;

		Node(int d) {

			data = d;
			next = null;

		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}
