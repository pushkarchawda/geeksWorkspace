package dynamicprogramming;

public class MinCostPath {

	public static void main(String[] args) {

		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		int Path[][] = new int[cost.length][cost[0].length];

		/*
		 * for(int i = 0;i<Path.length;i++) Path[0][i] = 0;
		 * 
		 * for(int i = 0;i<Path.length;i++) Path[i][0] = 0;
		 */
		System.out.println(minCost(cost, Path));
	}

	private static int minCost(int[][] cost, int[][] path) {

		// int min = 0;
		int l = cost.length;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) // more simplified version
										// http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
			{
				if (i == 0 && j == 0)
					path[i][j] = cost[i][j] + path[i][j];
				else if (i == 0)
					path[i][j] = cost[i][j] + path[i][j - 1];
				else if (j == 0)
					path[i][j] = cost[i][j] + path[i - 1][j];
				else
					path[i][j] = Math.min(path[i - 1][j], Math.min(path[i][j - 1], path[i - 1][j - 1])) + cost[i][j];
				// if(path[i][j] < min)
				// min = path[i][j];
			}
		}

		return path[l - 1][l - 1];
	}

}
