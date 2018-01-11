package stack_queue;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		int []arr = new int[]{11, 13, 21, 3};
		
		nextGreater(arr, arr.length);
		
	}	

	private static void nextGreater(int[] arr, int length) {

		Stack<Integer> s = new Stack<>();
		s.add(arr[0]);
		for(int i = 1;i<length;i++)
		{
			while(!s.isEmpty() && s.peek()<arr[i])
			{
				System.out.println(s.pop()+"->"+arr[i]);
			}
			
			s.push(arr[i]);
		}
		
		while(!s.isEmpty())
		{
			System.out.println(s.pop()+"->"+"-1");
		}
		
	}

}
