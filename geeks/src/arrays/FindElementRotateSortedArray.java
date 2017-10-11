package arrays;

public class FindElementRotateSortedArray {
	
	

	public static void main(String[] args) {

		int a[] = new int[]{4,5,1,2,3};
		int search = 3;
		int x = pivotedBinarySearch(a,search);
		System.out.println("Element "+a[x]+" present at "+ x);

	}

	private static int pivotedBinarySearch(int[] a, int search) {

		int pivot = findPivot(a, 0, a.length-1);
		if(pivot == -1)
			return binarySearch(a, 0, a.length-1, search);
		
		if(a[pivot] == search)
			return pivot;
		
		else if(a[pivot] > search)
		{
			return binarySearch(a, pivot+1, a.length-1, search);
		}
		else
			return binarySearch(a, 0, pivot, search);
	}
	
	public static int binarySearch(int a[], int low, int high, int x)
	{
		int mid = 0;
		
		if(low<=high)
		{
			mid = (low + high) / 2;
			if(a[mid] == x)
			{
				return mid;
			}
			else if(a[mid] < x)
			{
				return binarySearch(a, mid+1, high, x);
			}
			else
			{
				return binarySearch(a, low, mid-1, x);
			}
		}
		
		return -1;
	}

	private static int findPivot(int[] a, int low, int high) {

		int mid = 0;
		
		if(low<=high)
		{
			mid = (low + high) / 2;
			if(a[mid] > a[mid+1])
			{
				return mid;
			}
			else if(a[mid] < a[mid-1])
			{
				return mid-1;
			}
			else if(a[mid] > a[low])
			{
				return findPivot(a, mid + 1, high);
			}
			else
			{
				return findPivot(a, low, mid-1);
			}
		}
		
		return -1;
		
	}

}
