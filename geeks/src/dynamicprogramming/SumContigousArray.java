package dynamicprogramming;

public class SumContigousArray {

	public static void main(String[] args) {

		int arr[] = new int[]{-2, -3, -4, -1, -2, -1, -5, -3};
		int current = arr[0];
		int max = arr[0];

		for(int i = 1;i<arr.length;i++)
		{
			current = Math.max(arr[i], current+arr[i]);
			max = Math.max(max, current);
		}
		
		System.out.println("Max sum = "+max);
		
		
	}

}
