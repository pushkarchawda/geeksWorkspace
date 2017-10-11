package problems;

import java.util.Arrays;

/* Generate all the strings of n bits. Assume A[0..n – 1] is an array of size n. */

public class NBitsString {

	static int a[] = new int [2];
	
	public static void main(String[] args) {
		
		
		nBits(a.length-1);
	}

	private static void nBits(int i) {
		
		if(i < 0)
			System.out.println(Arrays.toString(a));
		else
		{
			a[i] = 0;
			nBits(i-1);
			a[i] = 1;
			nBits(i-1);
		}
	}

}
