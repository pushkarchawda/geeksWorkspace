package arrays;

/**
 * k largest(or smallest) elements in an array | added Min Heap method 2.8
 * Question: Write an efficient program for printing k largest elements in an
 * array. Elements in array can be in any order.
 * 
 * For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked
 * for the largest 3 elements i.e., k = 3 then your program should print 50, 30
 * and 23.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class K_Largest_Elements_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[]{1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		quickSort(arr, 0, arr.length-1);
		
		for(int i=arr.length-1;i>k;i--)
		{
			System.out.println(arr[i]);
		}
		
		

	}

	private static void quickSort(int[] arr, int low, int length) {

		if(low>length)
			return;
		
		int pIndex = findPartionIndex(arr, low, length);
		quickSort(arr, low, pIndex-1);
		quickSort(arr, pIndex+1, length);
		
	}

	private static int findPartionIndex(int[] arr,  int low, int high) {

		int pIndex = low;
		int pivot = arr[high];
		for(int i=low;i<high;i++)
		{
			if(arr[i]<pivot)
			{
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;			
			}
		}
		
		int temp = arr[high];
		arr[high] = arr[pIndex];
		arr[pIndex] = temp;
		
		return pIndex;
	}

}