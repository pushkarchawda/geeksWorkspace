package dyanamicprogramming;

public class MaximumSumWithoutAdjacent {

	public static void main(String[] args) {

		int x[] = new int[]{2,3,6,4,1,7};
		int max = maxSum(x, x.length);
		System.out.println("Max Sum = "+max);
	}

	private static int maxSum(int[] x, int length) {
		
		int inc = x[0];
		int exc = 0, exc_new = 0;

		for(int i = 1;i<length;i++)
		{
			exc_new = Math.max(inc, exc);
			inc = x[i] + exc;
			exc = exc_new;
		}
		
		return Math.max(inc, exc);
	}

}
