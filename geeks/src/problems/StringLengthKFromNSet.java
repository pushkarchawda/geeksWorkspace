package problems;

/* Print all possible strings of length k that can be formed from a set of n characters */

public class StringLengthKFromNSet {

	public static void main(String[] args) {

		int a[] = new int[]{ 1, 2, 3, 4 };
		int set[] = new int[1];
		stringLengthK(a, a.length - 1, set, 0);

	}

	private static void stringLengthK(int[] a, int length, int[] set, int x) {

		if (set.length == x) {
			for (int i = 0; i < set.length; i++) {
				System.out.print(set[i]);
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < a.length; i++) {
			set[x] = a[i];
			stringLengthK(a, length - 1, set, x+1);
		}

	}

}
