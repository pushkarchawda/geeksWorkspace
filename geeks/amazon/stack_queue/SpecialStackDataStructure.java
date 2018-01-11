package stack_queue;

import java.util.Stack;

public class SpecialStackDataStructure {

	public static void main(String[] args) {

		
		
	}
	
	

}

class SpecialStack extends Stack<Integer>{
	
	Stack<Integer> min;
	
	SpecialStack(){
		min = new Stack<>();
	}
	
	public boolean isEmpty()
	{
		return isEmpty();
	}
	
	public void push(int element)
	{
		if(isEmpty())
		{
			super.push(element);
			min.push(element);
		}
		else
		{
			/*if(element<min)
			{
				min = element;
				sMin.push(element);
			}*/
		}
	}
	
	
	
}
