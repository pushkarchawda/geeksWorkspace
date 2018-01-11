package collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;


interface A
{
	static int a = 10;
	final int b = 20;
}

interface B{
	
}

interface C extends A,B{
	
}


public class HashMapSort implements Comparator<Map.Entry<String, String>> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> unsortMap = new HashMap<String, String>();
		unsortMap.put("Z", "z");
		unsortMap.put("B", "b");
		unsortMap.put("A", "a");
		unsortMap.put("C", "c");
		unsortMap.put("D", "d");
		unsortMap.put("E", "e");
		unsortMap.put("Y", "y");
		unsortMap.put("N", "n");
		unsortMap.put("J", "j");
		unsortMap.put("M", "m");
		unsortMap.put("F", "f");
		unsortMap.put("W", "f");
		unsortMap.put("W", "g");
		unsortMap.put(null, "g");
		
		Map<String, String> unsortTreeMap = new TreeMap<String, String>();
		
		unsortTreeMap.put("W", "f");
		unsortTreeMap.put("W", "g");
		///unsortTreeMap.put(null, "g");

		Iterator it = unsortTreeMap.entrySet().iterator();

		while (it.hasNext())
			System.out.println(it.next());

		Iterator itq = unsortTreeMap.keySet().iterator();

		while (itq.hasNext())
			System.out.println(itq.next());

		for (String s : unsortMap.keySet())
			System.out.println("Key " + s + " " + "Value " + unsortMap.get(s));

		Set<Entry<String, String>> entrySt = unsortMap.entrySet();
		for (Entry e : entrySt) {
			System.out.println(e.getKey() + " " + e.getValue());
		}

		System.out.println("**********Sort********************");

		List<Map.Entry<String, String>> lis = new LinkedList<Map.Entry<String, String>>(unsortMap.entrySet());

		/*Collections.sort(lis, new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		});*/

		
		
		
		
		Collections.sort(lis,new HashMapSort());
		Map<String, String> unlinkedMap = new LinkedHashMap<String, String>();

		for (Entry<String, String> e : lis) {
			unlinkedMap.put(e.getKey(), e.getValue());
		}

		//Set<Entry<String, String>> entrySt1 = unlinkedMap.entrySet();
		for (Entry<String, String> e : unlinkedMap.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}

	@Override
	public int compare(Entry<String, String> o1, Entry<String, String> o2) {
		// TODO Auto-generated method stub
		return o1.getValue().compareTo(o2.getValue());
	}

}
