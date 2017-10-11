package linkedlist_stack_queue;

public class StackUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");

	}

}

class Stack {
	
	static final int max = 1000;
	int top;
	int a[] = new int[max];
	
	Stack() {
		top = -1;
	}

	boolean push(int aa) {
		if (top >= max) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = aa;
			return true;
		}
	}

	int pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			return a[top--];
		}
	}
	
	int peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			return a[top];
		}
	}
	
	boolean isEmpty()
	{
		if(top<0)
			return true;
		else
			return false;
	}
}
