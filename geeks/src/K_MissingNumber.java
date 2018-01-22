
public class K_MissingNumber {

	public static void main(String[] args) {
		
		int a[] = new int[]{2,4,8,9,12};
		int k = 15;
		int count = 0;
		find(a,0,a.length,count,k);
		
	}

	private static void find(int[] a, int low, int high, int count, int k) {
		
		while(low<high && (count+a.length)!=k)
		{
			int mid = (low+high)/2;
			//int indexToValue = a[mid] - mid;
			int diff = 0;
			if(mid!=0 && mid!=a.length)
			{
				diff = a[mid] - a[mid-1];
				while(diff<1)
				{
					count++;
					System.out.println(a[mid]+diff-1);
					diff--;
				}
			}
			else
			{
				if(mid==0)
				{
					while(diff<1)
					{
						count++;
						System.out.println(--diff);
					}
				}
				else if(mid == a.length)
				{
					diff = a[mid];
					while(diff<a.length)
					{
						count++;
						System.out.println(diff++);
					}
				}
					
			}
			find(a, low, mid-1, count, k);
			find(a, mid+1, high, count, k);
		}
		
	}

}
