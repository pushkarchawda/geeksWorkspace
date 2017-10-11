package sorting;

public class InsertionSort {

	public static void main(String[] args) {

		int a[] = new int[]{8,2,1,5,7,3,6,4,0,9,13,11,14,10,15,12};
		//System.out.println("0");
		insertonSort(a);
		//System.out.println("78");
		
		int ab[][] = new int [3][2];
		System.out.println("ln "+ab.length);
		
	}

	private static void insertonSort(int[] a) {
		for(int i=1; i<a.length;i++)
		{
			int value = a[i];
			int n = i-1;
		//	boolean flag = false;
			while(n>=0 && a[n]>value)
			{
				a[n+1] = a[n];
				n--;
		//		flag = true;
			}
		//	if(flag)
			a[n+1] = value;
			
		}
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
	}

}
