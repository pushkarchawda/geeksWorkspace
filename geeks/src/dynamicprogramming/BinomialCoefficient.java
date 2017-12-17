package dynamicprogramming;

/**
 * Following are common definition of Binomial Coefficients. 1) A binomial
 * coefficient C(n, k) can be defined as the coefficient of X^k in the expansion
 * of (1 + X)^n.
 * 
 * 2) A binomial coefficient C(n, k) also gives the number of ways, disregarding
 * order, that k objects can be chosen from among n objects; more formally, the
 * number of k-element subsets (or k-combinations) of an n-element set.
 * 
 * The Problem Write a function that takes two parameters n and k and returns
 * the value of Binomial Coefficient C(n, k). For example, your function should
 * return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 * 
 * 
 * 
 */

public class BinomialCoefficient {

	static int[][] coeff = new int[1000][1000];

	public static void main(String[] args) {

		int n = 4, k = 2;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j == 0 || i == j) {
					coeff[i][j] = 1;
				}

				if (coeff[i][j] == 0)
					coeff[i][j] = coeff[i - 1][j - 1] + coeff[i - 1][j];
			}
		}

		System.out.println(coeff[n][k]);

	}

}
