package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };//{12,9,13,25,32,10,64};//
        int n = arr.length;
        System.out.println("Length of lis is "
                           + lis(arr, n) + "");
		System.out.println();
	}

	private static int lis(int[] arr, int n) {

		int LIS[] = new int[arr.length];
		Arrays.fill(LIS, 1);
		int max = 1;
				
		for(int i = 0; i<LIS.length;i++)
		{
			for(int j = 0; j<i;j++)
			{
				if(arr[j]<arr[i])
				{
					if(LIS[i]<=LIS[j])
					{
						LIS[i] = LIS[i]+1;
					if(max < LIS[i])
							max = LIS[i];
					}
				}
			}
		}
		
		int maxR = max;
		
		for(int j = arr.length-1; j>=0;j--)
		{
			if(LIS[j] == max)
			{
				System.out.print(arr[j]+" ");
				max = max - 1;
			}
		}
		
		
		return maxR;
	}

}
