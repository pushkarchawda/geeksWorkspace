package stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {

		int []arr = new int[]{100,80,60,70,60,75,85};
		
		
		stockSpan(arr, arr.length);
		
		
	}

	private static void stockSpan(int[] arr, int length) {

		Stack<Integer> s = new Stack<Integer>();
		//Queue<Integer> q = new LinkedList();
		int []sArr = new int[length];
		
		s.push(0);
		sArr[0] = 1;
		System.out.println(arr[0]+" -> "+sArr[0]);
		for(int i=1 ;i<length;i++)
		{
			while(!s.isEmpty() && arr[s.peek()]<=arr[i])
			{
				s.pop();
			}
			sArr[i] = (s.isEmpty()? i+1 : i - s.peek());
			System.out.println(arr[i]+" -> "+sArr[i]);
			s.push(i);
			
		}
		
	}

}
