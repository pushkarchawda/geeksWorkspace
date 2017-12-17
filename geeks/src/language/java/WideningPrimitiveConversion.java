package language.java;

/**
 * Widening Primitive Conversion in Java 2.1 Here is a small code snippet given.
 * Try to Guess the output
 * 
 * public class Test { public static void main(String[] args) {
 * System.out.print("Y" + "O"); System.out.print('L' + 'O'); } } Run on IDE At
 * first glance, we expect “YOLO” to be printed.
 * 
 * Actual Output: “YO155”.
 * 
 * Explanation: When we use double quotes, the text is treated as a string and
 * “YO” is printed, but when we use single quotes, the characters ‘L’ and ‘O’
 * are converted to int. This is called widening primitive conversion. After
 * conversion to integer, the numbers are added ( ‘L’ is 76 and ‘O’ is 79) and
 * 155 is printed.
 * ***************************************************************************
 * 5.6.2. Binary Numeric Promotion
 * ***************************************************************************
 * When an operator applies binary numeric promotion to a pair of operands, each
 * of which must denote a value that is convertible to a numeric type, the
 * following rules apply, in order:
 * 
 * If any operand is of a reference type, it is subjected to unboxing conversion
 * (§5.1.8).
 * 
 * Widening primitive conversion (§5.1.2) is applied to convert either or both
 * operands as specified by the following rules:
 * 
 * If either operand is of type double, the other is converted to double.
 * 
 * Otherwise, if either operand is of type float, the other is converted to
 * float.
 * 
 * Otherwise, if either operand is of type long, the other is converted to long.
 * 
 * Otherwise, both operands are converted to type int.
 * 
 * After the type conversion, if any, value set conversion (§5.1.13) is applied
 * to each operand.
 * 
 * Binary numeric promotion is performed on the operands of certain operators:
 * 
 * The multiplicative operators *, / and % (§15.17)
 * 
 * The addition and subtraction operators for numeric types + and - (§15.18.2)
 * 
 * The numerical comparison operators <, <=, >, and >= (§15.20.1)
 * 
 * The numerical equality operators == and != (§15.21.1)
 * 
 * The integer bitwise operators &, ^, and | (§15.22.1)
 * 
 * In certain cases, the conditional operator ? : (§15.25)
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class WideningPrimitiveConversion {

	public static void main(String[] args) {

		System.out.print("Y" + "O");
		System.out.print('L');
		System.out.print('O');
		System.out.println("----------------------");
		/*
		 * Explanation: When we use double quotes, the text is treated as a
		 * string and “YO” is printed, but when we use single quotes, the
		 * characters ‘L’ and ‘O’ are converted to int. This is called widening
		 * primitive conversion. After conversion to integer, the numbers are
		 * added ( ‘L’ is 76 and ‘O’ is 79) and 155 is printed.
		 */
		System.out.print("Y" + "O");
		System.out.print('L' + 'O');
		System.out.println("----------------------");
		int i = 0;
		float f = 1.0f;
		double d = 2.0;
		// First int*float is promoted to float*float, then
		// float==double is promoted to double==double:
		if (i * f == d)
			System.out.println("oops");

		// A char&byte is promoted to int&int:
		byte b = 0x1f;
		char c = 'G';
		int control = c & b;
		System.out.println(Integer.toHexString(control));

		// Here int:float is promoted to float:float:
		f = (b == 0) ? i : 4.0f;
		System.out.println(1.0 / f);
	}

}
