package searching;

public class InterpolationSearch {

	public static void main(String[] args) {
		
		int a[] = new int[]{1,1,1,1,1,1,1,1,1};//{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		int index = interpolationSearch(a, 0, a.length-1, 1);
		
		System.out.println("Index : "+index);

	}

	private static int interpolationSearch(int[] a, int low, int high, int x) {
		// TODO Auto-generated method stub4
		if(low>=high)
			return -1;
		
		if(a[low] == a[high])
			return low + (high-low)/2;
		
		int pos = (int) (low + ((high-low)*(x-a[low])/(a[high]-a[low])));	
		
		if(a[pos] == x)
			return x;	
		else if(a[pos] < x)
			return interpolationSearch(a, pos+1, a.length-1, x);
		else
			return interpolationSearch(a, 0, pos-1, x);
		 
		
	}

}
