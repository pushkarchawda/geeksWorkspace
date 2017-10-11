package sorting;

public class SelectionSort {
	
	public static void main(String[] args) {

		int a[] = new int[]{8,2,1,5,7,3,6,4,0,9,13,11,14,10,15,12};
		
		selectionSort(a);
		
	}

	private static void selectionSort(int[] a) {
		// TODO Auto-generated method stub
		int min = 0;
		
		for(int i = 0; i < a.length ; i++)
		{
			min = i;
			
			for(int j = i+1; j < a.length ; j++)
			{
				if(a[j] < a[min])
				{
					min = j;
				}
			}
			
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		for(int j = 0; j < a.length ; j++)
		{
			System.out.println(a[j]);
		}
		
		
	}

}
