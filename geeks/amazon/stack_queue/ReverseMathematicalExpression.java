package stack_queue;

import java.util.Stack;

/**
 *  Input : 5*2 + 3 - 10
 * 	Output: 10 - 3 + 2 * 5
 * @author PUSHKAR CHAWDA
 *
 */

public class ReverseMathematicalExpression {

		public static void main(String[] args) {
			
			Stack<String> s1 = new Stack();
			Stack<String> s2 = new Stack();
			
			String s = "50*2 + 3 - 10";
			StringBuilder sb;
			
			System.out.println("Given Input :"+s);
			
			for(int i = 0;i<s.length();)
			{
				if(s.charAt(i)>='0' && s.charAt(i)<='9')
				{
					sb = new StringBuilder();
					while(i < s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
					{
						sb.append(s.charAt(i));
						i++;
					}
					
					s2.push(sb.toString());
				}
				else if(s.charAt(i) == ' ')
				{
					i++;
				}
				else
				{
					s1.push(s.charAt(i)+"");
					i++;
				}
				
				
			}
			
			while(!s1.isEmpty() && !s2.isEmpty())
			{
				System.out.print(s2.pop()+" "+s1.pop()+" ");
			}
			
			System.out.print(s2.pop());
	}

}
