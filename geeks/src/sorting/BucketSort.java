package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

	public static void main(String[] args) {

		int a[] = new int[] { 8, 2, 1, 5, 7, 3, 6, 4, 0, 9, 13, 11, 14, 10, 15, 12 };

		bucketSort(a);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	private static void bucketSort(int[] a) {
		// TODO Auto-generated method stub
		int[] code = hash(a);
		
		ArrayList<Integer>[] buckets = new ArrayList[code[1]];
		
		for(int x=0;x<code[1];x++)
		{
			buckets[x] = new ArrayList<Integer>();
		}
		
		for(int x=0;x<a.length;x++)
		{
			buckets[hash(a[x], code)].add(a[x]) ;
		}
		
		for(ArrayList x : buckets)
		{
			Collections.sort(x);
		}
		
		int count = 0;
		
		for(int x=0;x<buckets.length;x++)
		{
			for(int i : buckets[x])
			{
				a[count] = i;
				count++;
			}
		}
		
	}

	private static int hash(int i, int[] code) {
		// TODO Auto-generated method stub
		return (int) ((double)i/code[0]*(code[1]-1));
	}

	private static int[] hash(int[] a) {
		// TODO Auto-generated method stub
		int max = a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i] > max)
				max = a[i];
		}
		return new int[]{max, (int) Math.sqrt(a.length)};
	}

}
