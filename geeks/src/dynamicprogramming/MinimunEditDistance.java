package dynamicprogramming;

public class MinimunEditDistance {
	
	static int [][]EditMat; 

	public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        
        System.out.println( editDist( str1 , str2 , str1.length(), str2.length()) );
    }

	private static int editDist(String str1, String str2, int length1, int length2) {
		// TODO Auto-generated method stub
		
		EditMat = new int[length1+1][length2+1];
		
		for(int i = 0 ; i <= length1 ; i++)
		{
			for(int j = 0 ; j <= length2 ; j++)
			{
				if(i == 0 && j!=0)
				{
					EditMat[0][j] = j;
				}
				
				if(j == 0)
				{
					EditMat[i][0] = i;
				}
				
				if(i>0 && j > 0 && str1.charAt(i-1) == str2.charAt(j-1))
				{
					EditMat[i][j] = EditMat[i-1][j-1];
				}
				else
				{
					if(i>0 && j > 0)
					{
						EditMat[i][j] = Math.min(EditMat[i][j-1], Math.min(EditMat[i-1][j], EditMat[i-1][j-1]))+1;
					}
				}
				
			}
		}
		
		return EditMat[length1][length2];
	}

}
