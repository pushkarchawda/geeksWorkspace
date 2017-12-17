package language.java;

/**
 * 
 * Type conversion in Java with Examples 1.8 When you assign value of one data
 * type to another, the two types might not be compatible with each other. If
 * the data types are compatible, then Java will perform the conversion
 * automatically known as Automatic Type Conversion and if not then they need to
 * be casted or converted explicitly. For example, assigning an int value to a
 * long variable.
 * 
 * Widening or Automatic Type Conversion
 * 
 * Widening conversion takes place when two data types are automatically
 * converted. This happens when:
 * 
 * The two data types are compatible. When we assign value of a smaller data
 * type to a bigger data type. For Example, in java the numeric data types are
 * compatible with each other but no automatic conversion is supported from
 * numeric type to char or boolean. Also, char and boolean are not compatible
 * with each other.
 * 
 * Byte -> Short -> Int -> Long -> Float -> Double
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class Typeconversion {

	public static void main(String[] args) {

		System.out.println("Widening or Automatic Type Conversion");
		int i = 100;

		// automatic type conversion
		long l = i;

		// automatic type conversion
		float f = l;
		System.out.println("Int value " + i);
		System.out.println("Long value " + l);
		System.out.println("Float value " + f);

		// Narrowing or Explicit Conversion
		System.out.println("Narrowing or Explicit Conversion");

		/*
		 * If we want to assign a value of larger data type to a smaller data
		 * type we perform explicit type casting or narrowing.
		 * 
		 * This is useful for incompatible data types where automatic conversion
		 * cannot be done. Here, target-type specifies the desired type to
		 * convert the specified value to.
		 */
		// Byte <- Short <- Int <- Long <- Float <- Double

		double d = 100.04;

		// explicit type casting
		long l1 = (long) d;

		// explicit type casting
		int i1 = (int) l;
		System.out.println("Double value " + d);

		// fractional part lost
		System.out.println("Long value " + l1);

		// fractional part lost
		System.out.println("Int value " + i1);

		/*
		 * char and number are not compatible with each other. Let’s see when we
		 * try to convert one into other.
		 */
		char ch = 'c';
		int num = 88;
		// ch = num; -- not compatible hence commented

		/*
		 * While assigning value to byte type the fractional part is lost and is
		 * reduced to modulo 256(range of byte).
		 */

		System.out.println("Assigning value to byte type");
		byte b;
		int i2 = 257;
		double d2 = 323.142;
		System.out.println("Conversion of int to byte.");

		// i%256
		b = (byte) i2;
		System.out.println("i = b " + i2 + " b = " + b);
		System.out.println("\nConversion of double to byte.");

		// d%256
		b = (byte) d2;
		System.out.println("d = " + d2 + " b= " + b);

		System.out.println("Type promotion in Expressions");

		/*
		 * 
		 * While evaluating expressions, the intermediate value may exceed the
		 * range of operands and hence the expression value will be promoted.
		 * Some conditions for type promotion are:
		 * 
		 * Java automatically promotes each byte, short, or char operand to int
		 * when evaluating an expression. If one operand is a long, float or
		 * double the whole expression is promoted to long, float or double
		 * respectively.
		 * 
		 */

		byte b3 = 42;
		char c3 = 'a';
		short s3 = 1024;
		int i3 = 50000;
		float f3 = 5.67f;
		double d3 = .1234;

		// The Expression
		double result = (f3 * b3) + (i3 / c3) - (d3 * s3);

		// Result after all the promotions are done
		System.out.println("result = " + result);

	}

}
