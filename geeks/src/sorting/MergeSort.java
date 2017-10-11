package sorting;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[]{8,2,1,5,7,3,6,4,0,9,13,11,14,10,15,12};
		
		mergeSort(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}

	}

	private static void mergeSort(int[] a) {
		// TODO Auto-generated method stub
		
		if(a.length == 1)
		{
			return;
		}
		
		int x = a.length;
		
		int l[] = new int[x/2];
		int r[] = new int[x/2];
		
		for(int i=0;i<x/2;i++)
		{
			l[i] = a[i];
		}
		
		for(int i= x/2;i<x;i++)
		{
			r[i-x/2] = a[i];
		}
		
		mergeSort(l);
		mergeSort(r);
		merge(l, r, a);
		
	}

	private static void merge(int[] l, int[] r, int a[]) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, k = 0 ;
		while(i<l.length && j < r.length)
		{
			if(l[i] > r[j])
			{
				a[k] = r[j];
				j++;
				k++;
			}
			else
			{
				a[k] = l[i];
				i++;
				k++;
			}
		}
		
		while(i<l.length)
		{
			a[k] = l[i];
			i++;
			k++;
		}
		while(j<r.length)
		{
			a[k] = r[j];
			j++;
			k++;
		}	
		
	}

}
