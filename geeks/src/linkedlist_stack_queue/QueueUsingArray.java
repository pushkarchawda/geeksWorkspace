package linkedlist_stack_queue;

public class QueueUsingArray {

	public static void main(String[] args) {

		 	Queue queue = new Queue(1000);
         
	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);
	        queue.enqueue(40);
	       
	        System.out.println(queue.dequeue() + 
	                     " dequeued from queue\n");
	       
	        System.out.println("Front item is " + 
	                               queue.front());
	          
	        System.out.println("Rear item is " + 
	                                queue.rear());
		
	}

}

class Queue{
	
	int front, rear, capacity, size;
	int a[];
	
	Queue(int c){
		front = size = 0;
		capacity = c;
		rear = capacity - 1;
		a = new int[capacity];
	}
	
	boolean isEmpty()
	{
		return (size == 0);
	}
	
	
	boolean isFull()
	{
		return (size == capacity);
	}
	
	boolean enqueue(int i)
	{
		if(isFull())
			return false;
		
		rear = (rear + 1)%capacity;
		a[rear] = i;
		size++;
		return true;
		
	}
	
	int dequeue()
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		int x = a[front];
		front = (front + 1)%capacity;
		size--;
		return x;
	}
	
	int front()
	{
		if(isEmpty())
			return Integer.MIN_VALUE;
		
		return a[front];
		
	}
	
	int rear()
    {
        if (isEmpty())
            return Integer.MIN_VALUE;
          
        return a[rear];
    }
	
	
}
