package arrays;

import java.util.ArrayList;
import java.util.Iterator;

public class MatrixRotation90Degree_AnticlockWise {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int N = 4;
        
        // Test Case 1
        int mat[][] =
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        System.out.println("AntiClock Wise");
        rotateMatrixAntiClockWise(N,mat);
        // Print rotated matrix
        displayMatrix(N,mat);
        System.out.println("Clock Wise");
        rotateMatrixClockWise(N,mat);
        // Print rotated matrix
        displayMatrix(N,mat);

	}
	
	private static void rotateMatrixAntiClockWise(int n, int[][] mat) {

		for(int i = 0;i<n/2;i++)
		{
			for(int j = i;j<n-1-i;j++)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[j][n-1-i];
				mat[j][n-1-i] = mat[n-1-i][n-1-j];
				mat[n-1-i][n-1-j] = mat[n-1-j][i];
				mat[n-1-j][i] = temp;
			}
		}
		
	}
	
	private static void rotateMatrixClockWise(int n, int[][] mat) {

		for(int i = 0;i<n/2;i++)
		{
			for(int j = i;j<n-1-i;j++)
			{
				int temp = mat[i][j];
				mat[i][j] = mat[n-1-j][i];
				mat[n-1-j][i] = mat[n-1-i][n-1-j];
				mat[n-1-i][n-1-j] = mat[j][n-1-i];
				mat[j][n-1-i] = temp;
			}
		}
		
	}

	static void displayMatrix(int N, int mat[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);
      
            System.out.print("\n");
        }
        System.out.print("\n");
    }

}
