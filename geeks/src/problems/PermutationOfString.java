package problems;

/* Write a program to print all permutations of a given string */

public class PermutationOfString {

	public static void main(String[] args) {

		String s = "abc";
		char c[] = s.toCharArray();
		permute(c,c.length, "", 0);

	}

	private static void permute(char[] c, int i, String string, int x) {

		if(x == c.length)
		{
			System.out.println(string);
			return;
		}
			
		for(int k = x; k<c.length;k++)
		{
			String nString = string + c[k];
			permute(c,i, nString, x+1);
			
		}
	}
}
