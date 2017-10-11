package problems;

/* Given an array, check whether the array is in sorted order with recursion. */

public class CheckArrayIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[]{1,2,3,4,7,6};
		
		System.out.println(checkSorted(a, a.length-1));

	}

	private static boolean checkSorted(int[] a, int n) {

		if(n == 0)
			return true;
		
		return a[n] > a[n-1] ? checkSorted(a, n-1) : false;
		
		
	}

}
