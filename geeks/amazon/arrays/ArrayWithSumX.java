package arrays;

import java.util.Arrays;
/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x 2.1
 * Write a C program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose sum is exactly
 * x.
 * 
 * @author PUSHKAR CHAWDA
 *
 */
public class ArrayWithSumX {

	public static void main(String[] args) {

		int arr[] = new int[] { 3, 1, 4, 6, 5 };
		Arrays.sort(arr); // 1st approach
		findSumPair(arr, 7);
	}

	private static void findSumPair(int[] arr, int x) {
		
		boolean check[] = new boolean[1000];
		
		for(int i=0;i<arr.length;i++)
		{
			int temp = x - arr[i];
			if(temp >=0 && check[temp])
				System.out.println("L " + arr[i] + " " + "H " + temp);
			
			check[arr[i]] = true;
		}
	}

	//O(nLogn) as we need to sort
	/*private static void findSumPair(int[] arr, int x) {
		int n = arr.length;
		int l = 0, h = n - 1;
		while (l < h) {
			if (arr[l] + arr[h] == x) {
				System.out.println("L " + arr[l] + " " + "H " + arr[h]);
				l++;
				h--;
			} else if (arr[l] + arr[h] > x) {
				h--;
			} else {
				l++;
			}
		}
	}*/
}
