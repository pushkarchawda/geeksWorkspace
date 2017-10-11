package sorting;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = new int[] { 8, 2, 1, 5, 7, 3, 6, 4, 0, 9, 13, 11, 14, 10, 15, 12 };

		quickSort(a, 0, a.length-1);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	private static void quickSort(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end)
			return;
		
		int pIndex = partition(a, start, end);
		quickSort(a, start, pIndex-1);
		quickSort(a, pIndex+1, end);
		
		
	}

	private static int partition(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = a[end];
		int pIndex = start;
		for(int i=start;i<=end-1;i++)
		{
			if(a[i]<=pivot)
			{
				int tmp = a[i];
				a[i] =  a[pIndex];
				a[pIndex] = tmp;
				pIndex++;
			}
		}
		
		int tmp = a[end];
		a[end] =  a[pIndex];
		a[pIndex] = tmp;
		
		return pIndex;
	}
	
	

}
