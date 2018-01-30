package dynamicprogramming;

public class SubsetGivenSum {

	static boolean[][] subsetSumMat;

	public static void main(String[] args) {

		int set[] = { 3, 6, 34, 4, 12, 5, 6 };
		int sum = 9;
		int n = set.length;

		subsetSumMat = new boolean[n + 1][sum + 1];

		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}

	private static boolean isSubsetSum(int[] set, int n, int sum) {

		for (int j = 0; j <= n; j++) {
			subsetSumMat[j][0] = true;
		}

		for (int j = 1; j <= sum; j++) {
			subsetSumMat[0][j] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (set[i - 1] > j)
					subsetSumMat[i][j] = subsetSumMat[i - 1][j];
				else
					subsetSumMat[i][j] = subsetSumMat[i - 1][j] || subsetSumMat[i - 1][j - set[i - 1]];
			}
		}

		here : for (int i = n; i > 0;) {
			for (int j = sum; j > 0;) {
				
				if (subsetSumMat[i][j] != subsetSumMat[i-1][j]) {
					System.out.print(set[i - 1] + " ");
					j = j-set[i-1];;
				} else {
					i = i - 1;
				}
				if(j == 0)
				{
					break here;
				}

			}
		}
		System.out.println();
		return subsetSumMat[n][sum];

	}

}
