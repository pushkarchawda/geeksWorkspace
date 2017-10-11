package sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
		
		radixSort(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}

	}

	private static void radixSort(int[] a) {
		// TODO Auto-generated method stub
		int max = findMax(a, a.length);
		
		for(int exp=1;max/exp>0;exp*=10)
		{
			countSort(a, a.length, exp);
		}
		
	}

	private static void countSort(int[] a, int length, int exp) {
		// TODO Auto-generated method stub
		int count[] = new int[10];
		int output[] = new int[a.length];
		
		Arrays.fill(count, 0);
		
		for(int i=0;i<length;i++)
		{
			count[(a[i]/exp)%10]++;
		}
		
		for(int i=1;i<10;i++)
		{
			count[i]+=count[i-1];
		}
		
		for(int i=0;i<length;i++)
		{
			output[count[(a[i]/exp)%10] - 1] = a[i];
			count[(a[i]/exp)%10]--;
		}
		
		for(int i=0;i<length;i++)
		{
			a[i] = output[i];
		}
		
		
	}

	private static int findMax(int[] a, int length) {
		// TODO Auto-generated method stub
		int max = a[0];
		for(int i=1;i<length;i++)
		{
			if(a[i]>max)
				max = a[i];
		}
		return max;
	}

}
