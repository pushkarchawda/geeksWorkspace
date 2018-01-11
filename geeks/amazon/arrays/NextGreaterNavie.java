package arrays;

public class NextGreaterNavie {

	public static void main(String[] args) {

		int a[] = new int[]{85,75,60,70,60,80,100};
		
		for(int i = 0;i<a.length;i++)
		{
			int x = -1;
			for(int j = i+1;j<a.length;j++)
			{
				if(a[i]<a[j])
				{
					x = a[j];
					break;
				}
			}
			System.out.println(a[i]+" -> "+x);
		}
		
	}

}
