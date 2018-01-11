package collections;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		ArrayListBasic a = new ArrayListBasic();
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		
		System.out.println(a);
		
		System.out.println(System.identityHashCode(a));
		System.out.println(Integer.toHexString(System.identityHashCode(a)));
		
		/*ArrayList as = new ArrayList<>();
		as.add(1);
		as.add(2);
		as.add(3);
		as.add(4);
		System.out.println(as);*/
		
	}

}
