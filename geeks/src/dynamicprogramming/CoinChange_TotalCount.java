package dynamicprogramming;

public class CoinChange_TotalCount {
	
	static int [][]MaxCoin;

	public static void main(String[] args) {
		
		int coin[] = new int[]{1,2,3};
		int value = 5;
		
		MaxCoin = new int[coin.length+1][value+1];
		
		/*for(int i = 1; i <= value ; i++)
		{
			MaxCoin[0][i] = 0;
		}*/
		
		for(int i = 1; i <= coin.length ; i++)
		{
			for(int j = 0; j <= value ; j++)
			{
				if(j == 0)
				{
					MaxCoin[i][j] = 1;
					continue;
				}
				
				if(coin[i-1] > j)
				{
					MaxCoin[i][j] = MaxCoin[i-1][j];
				}
				else
				{
					MaxCoin[i][j] = MaxCoin[i-1][j] + MaxCoin[i][j-i];
				}
				
			}
		}
		
		System.out.println("Max ways to get "+value+" is "+MaxCoin[coin.length][value]);

	}

}
