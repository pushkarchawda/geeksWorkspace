package arrays;

import java.util.Arrays;

public class MinimumlengthUnsortedSubarray {

	public static void main(String[] args) {
		int a[] = new int[] { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		findMinLength(a);
	}

	private static void findMinLength(int[] a) {
		int x[] = a.clone();
		Arrays.sort(x);
		int i = 0, j = a.length-1, count = 0;
		while(i == count)
		{
			if(a[i] == x[i])
			{
				i++;
			}
			count++;
		}
		count = j;
		while(j == count)
		{
			if(a[j] == x[j])
			{
				j--;
			}
			count--;
		}
		System.out.println("a :"+Arrays.toString(a));
		System.out.println("x :"+Arrays.toString(a));
		System.out.println("starting "+i+" ending "+j);
	}
}
