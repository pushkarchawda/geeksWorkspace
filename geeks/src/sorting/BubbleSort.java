package sorting;

public class BubbleSort {

	public static void main(String[] args) {

		int a[] = new int[]{8,2,1,5,7,3,6,4,0,9,13,11,14,10,15,12};//{2,3,8,4,5,0};//
		
		bubbleSort(a);
		
	}

	private static void bubbleSort(int[] a) {

		boolean flag = true;
		int count = 0;
				
		for(int j=0;j<a.length;j++)
		{
			for(int i=0;i<a.length-j-1;i++)
			{
				if(a[i]>a[i+1])
				{
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
			
		}
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+",");
		}
		
	}
	
}
