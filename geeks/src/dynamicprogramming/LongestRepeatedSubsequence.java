package dynamicprogramming;

/**
 * Given a string, print the longest repeating subseequence such that the two
 * subsequence don’t have same string character at same position, i.e., any i’th
 * character in the two subsequences shouldn’t have the same index in the
 * original string.
 * 
 * 
 * 
 * More Examples:
 * 
 * Input: str = "aabb" Output: "ab"
 * 
 * Input: str = "aab" Output: "a" The two subssequence are 'a'(first) and 'a'
 * (second). Note that 'b' cannot be considered as part of subsequence as it
 * would be at same index in both.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class LongestRepeatedSubsequence {

	static int[][] LRS;

	public static void main(String[] args) {

		String x = "AABEBCDD";
		// String y = "AYZXTREWFHNKVDES";

		LRS = new int[x.length() + 1][x.length() + 1];

		char[] cX = x.toCharArray();
		// char[] cY= y.toCharArray();

		for (int i = 1; i < cX.length + 1; i++) {
			for (int j = 1; j < cX.length + 1; j++) {
				if (cX[i - 1] != cX[j - 1])
					LRS[i][j] = (LRS[i - 1][j] > LRS[i][j - 1]) ? LRS[i - 1][j] : LRS[i][j - 1];
				else if ((i - 1) == (j - 1))
					LRS[i][j] = (LRS[i - 1][j] > LRS[i][j - 1]) ? LRS[i - 1][j] : LRS[i][j - 1];
				else
					LRS[i][j] = LRS[i - 1][j - 1] + 1;
			}
		}

		int i = cX.length;
		int j = cX.length;

		while (i != 0 && j != 0) {

			if (LRS[i][j - 1] == LRS[i - 1][j]) {
				if (LRS[i][j] == LRS[i - 1][j - 1] + 1) {
					System.out.print(cX[i - 1]);
				}
				j = j - 1;
				i = i - 1;
			}

			else if (LRS[i][j - 1] > LRS[i - 1][j]) {
				j = j - 1;

			} else if (LRS[i][j - 1] < LRS[i - 1][j]) {
				i = i - 1;
			}

		}
	}

}
