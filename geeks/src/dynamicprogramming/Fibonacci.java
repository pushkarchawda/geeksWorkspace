package dynamicprogramming;

public class Fibonacci {
	
	static int []fib = new int[100000];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fib[0] = 0;
		fib[1] = 1;
		System.out.println(fib(9));

	}

	private static int fib(int i) {
		// TODO Auto-generated method stub
		if(i == 0)
			return fib[0];
		
		if(fib[i] != 0)
			return fib[i];
		
		return (fib[i] = fib(i-1) + fib(i-2));
	}

}
