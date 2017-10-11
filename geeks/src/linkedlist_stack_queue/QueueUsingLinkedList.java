package linkedlist_stack_queue;

public class QueueUsingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueL q=new QueueL();
        q.enqueue(10);
        /*q.enqueue(20);
        q.enqueue(60);
        q.enqueue(70);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);*/
         
        System.out.println("Dequeued item is "+ q.dequeue());
        System.out.println("Dequeued item is "+ q.dequeue());

	}

}

class QueueL
{
	NodeQ front, rear;
	
	QueueL()
	{
		front = rear = null;
	}
	
	boolean enqueue(int d)
	{
		NodeQ temp = new NodeQ(d);
		
		if(front == null)
		{
			front = rear = temp;
			return true;
		}
		
		rear.setNext(temp);
		rear = temp;
		return true;
	}
	
	int dequeue()
	{
		if(front == null)
			return Integer.MIN_VALUE;
		
		NodeQ temp = front;
		front = front.getNext();
		
		if(front == null)
			rear = null;
		
		
		return temp.getData();
		
		
		
	}
}

class NodeQ
{
	int data;
	NodeQ next;
	
	NodeQ(int d){ data = d; next = null;}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeQ getNext() {
		return next;
	}

	public void setNext(NodeQ next) {
		this.next = next;
	}
	
	
}