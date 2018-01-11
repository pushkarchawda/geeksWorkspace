package dyanamicprogramming;

public class EditDistance {
	
	static int table[][];

	public static void main(String[] args) {

		String str1 = "sunday";
	    String str2 = "saturday";
	    
	    table = new int[str1.length()+1][str2.length()+1];
	 
	    System.out.println("Minimun manupulation required is "+editDistDP(str1, str2, str1.length(), str2.length()));
	}

	private static int editDistDP(String str1, String str2, int length1, int length2) {

		for(int i=0;i<=length1;i++)
		{
			for(int j=0;j<=length2;j++)
			{
				if(j == 0)
				{
					table[i][j] = i;
					continue;
				}
				
				if(i == 0 & j!=0)
				{
					table[0][j] = j;
					continue;
				}
				
				if(i>0 && j>0 && str1.charAt(i-1) == str2.charAt(j-1))
				{
					table[i][j] = table[i-1][j-1];
				}
				else
				{
					if(i>0 && j>0)
						table[i][j] = Math.min(table[i][j-1], Math.min(table[i-1][j], table[i-1][j-1]))+1;
				}
			}
		}
		return table[length1][length2];
		
	}

}
