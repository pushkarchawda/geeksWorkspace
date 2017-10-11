package searching;

public class LinearSearh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		for(int x = 0; x<a.length ; x++)
		{
			if(a[x] == 5)
			{
				System.out.println("Found "+a[x]);
				break;
			}
		}

	}

}
