package dynamicprogramming;

/**
 * 
 * We have discussed Overlapping Subproblems and Optimal Substructure properties
 * in Set 1 and Set 2 respectively. We also discussed one example problem in Set
 * 3. Let us discuss Longest Common Subsequence (LCS) problem as one more
 * example problem that can be solved using Dynamic Programming.
 * 
 * LCS Problem Statement: Given two sequences, find the length of longest
 * subsequence present in both of them. A subsequence is a sequence that appears
 * in the same relative order, but not necessarily contiguous. For example,
 * “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * 
 * It is a classic computer science problem, the basis of diff (a file
 * comparison program that outputs the differences between two files), and has
 * applications in bioinformatics.
 * 
 * Examples: LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class LongestCommonSubsequence {

	static int[][] LCS;

	public static void main(String[] args) {

		String x = "AXYZATYOPRGHK";
		String y = "AYZXTREWFHNKVDES";

		LCS = new int[x.length() + 1][y.length() + 1];

		char[] cX = x.toCharArray();
		char[] cY = y.toCharArray();

		for (int i = 1; i < cX.length + 1; i++) {
			for (int j = 1; j < cY.length + 1; j++) {
				if (cX[i - 1] != cY[j - 1])
					LCS[i][j] = (LCS[i - 1][j] > LCS[i][j - 1]) ? LCS[i - 1][j] : LCS[i][j - 1];
				else
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
			}
		}

		int i = cX.length;
		int j = cY.length;

		while (i != 0 && j != 0) {

			if (LCS[i][j - 1] == LCS[i - 1][j]) {
				if (LCS[i][j] == LCS[i - 1][j - 1] + 1) {
					System.out.print(cX[i - 1]);
				}
				j = j - 1;
				i = i - 1;
			}

			else if (LCS[i][j - 1] > LCS[i - 1][j]) {
				j = j - 1;

			} else if (LCS[i][j - 1] < LCS[i - 1][j]) {
				i = i - 1;
			}

		}

	}

}
