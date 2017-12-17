package dynamicprogramming;

public class CuttingRod {

	static int[][] maxValMat;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rods = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] values = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };

		int rodLength = 8;

		maxValMat = new int[rods.length + 1][rodLength + 1];

		System.out.println("Max " + cuttingRod(rods, values, rodLength));

	}

	private static int cuttingRod(int[] rods, int[] values, int rodLength) {

		int max = 0;
		
		for (int i = 0; i <= rods.length; i++) {
			for (int j = 0; j <= rodLength; j++) {
				if (i == 0 && j != 0) {
					maxValMat[0][j] = 0;
				}

				if (j == 0) {
					maxValMat[i][0] = 0;
				}

				if (i > 0 && j > 0 && i > j) {
					maxValMat[i][j] = maxValMat[i - 1][j];
				} else {
					if (i > 0 && j > 0)
						maxValMat[i][j] = Math.max(maxValMat[i-1][j], values[i-1] + maxValMat[i][j - i]);
				}
				
				if(max<maxValMat[i][j])
					max = maxValMat[i][j];

			}
		}
		
		
		
		here : for (int i = rods.length; i > 0;) {
			for (int j = rodLength; j > 0; ) {
				
				if(maxValMat[i][j] == maxValMat[i-1][j])
				{
					i = i-1;
					continue;
				}
				else
				{
					System.out.print(i+" ");
					j = j-i;
					if(maxValMat[i][j] == 0)
						break here;
				}
			}
		}
		System.out.println();
		return max;
	}

}
