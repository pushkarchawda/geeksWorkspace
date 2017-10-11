package searching;

public class TernarySearch {
	
	public static void main(String[] args) {

		int a[] = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		int x = ternarySearch(a, 9, 0, a.length-1);
		
		if(x!=-1)
			System.out.println("Found at index "+x);
		
	}

	private static int ternarySearch(int[] a, int i, int l, int r) {

		if(l>r)
		{
			return -1;
		}
		
		int x = -1;
		
		int mid1 = l + (r-l)/2;
		
		int mid2 = mid1 + (r-l)/2;
		
		if(i == a[mid1])
		{
			return mid1;
		}
		else if(i == a[mid2])
		{
			return mid2;
		}
		else if(i < a[mid1])
		{
			x = ternarySearch(a,i,l, mid1-1);
		}
		else if(i > a[mid2])
		{
			x = ternarySearch(a,i,mid2+1,r);
		}
		else
		{
			x = ternarySearch(a,i,mid1+1,mid2-1);
		}
		
		return x;
	}

}
