package _akspractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		HashMap<Character, Integer> hmap = new HashMap<>();
		print(hmap);
		
		// inserting
		hmap.put('a', 1);
		hmap.put('b', 1);
		hmap.put('c', 1);
		hmap.put('d', 1);
		hmap.put('e', 1);
		hmap.put('a', 2);
		hmap.put('b', 2);
		hmap.put('c', 2);
		System.out.println("after insertion into hashmap");
		print(hmap);
		if(!hmap.isEmpty()){
			System.out.println("a "+ hmap.get('a'));
		}
		// iterating hashmap
		// method 1 Iterating or looping map using java5 foreach loop"
		System.out.println("Using method 1****************** ");

		for(Character ch: hmap.keySet()){
			System.out.println("key = "+ch+ " value "+ hmap.get(ch));
		}
		
		// method 2  Iterating Map in Java using KeySet Iterator
		System.out.println("Using method 2************************ ");
		Set<Character> s = hmap.keySet();
		Iterator<Character> itr =  s.iterator();
		while(itr.hasNext()){
			Character key = itr.next();
			System.out.println("key = "+key+ " value "+ hmap.get(key));
		}
		// method 3 looping HashMap in Java using EntrySet and java5 for loop
				System.out.println("Using method 3 ******************");
				Set<Map.Entry<Character, Integer>> es = hmap.entrySet();
				for(Entry ch: es){
					System.out.println("key = "+ch.getKey()+ " value "+ ch.getValue());
				}
		// method 4 Iterating HashMap in Java using EntrySet and Java iterator
				System.out.println("Using method 4 ******************");
				Set<Map.Entry<Character, Integer>> eset = hmap.entrySet();
				Iterator<Entry<Character, Integer>> iter =  eset.iterator();
				while(iter.hasNext()){
					Entry e = iter.next();
					System.out.println("key = "+e.getKey()+ " value "+ e.getValue());
				}
	}  
public static void print(HashMap<Character, Integer> hmap){
	if(hmap.isEmpty()){
		System.out.println("Hashmap is empty");
	} else{
		System.out.println(hmap);
	}
}
}
