package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ElementAppearOnce {

	public static void main(String[] args) {

		 int arr[] = {3, 3, 2, 3};
		 int n = arr.length;
	     System.out.println("The element with single occurrence is " + getSingle(arr, n));
	}

	private static int getSingle(int[] arr, int n) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			int x = arr[i];
			if(hm.containsKey(x))
			{
				int y = hm.get(x);
				hm.put(x, ++y);
			}
			else
			{
				hm.put(x, 1);
			}
		}
		
		List<Map.Entry<Integer, Integer>> l = new ArrayList<>(hm.entrySet());
		
		Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		Iterator<Entry<Integer, Integer>> it = l.iterator();
		if(it.hasNext())
		{
			Entry<Integer, Integer> e = it.next();
			int k = e.getKey();
			int v = e.getValue();
			if( v == 1)
				return k;
			else
				return -1;
		}
				
		else
			return -1;
		
	}

}
