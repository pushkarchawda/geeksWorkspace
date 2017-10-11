package searching;

public class BinarySearch {

	public static void main(String[] args) {

		int a[] = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		int x = binarySearch(a, 15, 0, a.length-1);
		
		if(x!=-1)
			System.out.println("Found at index "+x);
		
	}

	private static int binarySearch(int[] a, int i, int l, int r) {

		if(l>r)
		{
			return -1;
		}
		
		int x = -1;
		
		int mid = l + (r-l)/2;
		
		System.out.println(mid);
		
		if(i == a[mid])
		{
			return mid;
		}
		else if(i < a[mid])
		{
			x = binarySearch(a,i,l, mid-1);
		}
		else
		{
			x = binarySearch(a,i,mid+1,r);
		}
		
		return x;
		
	}

}
