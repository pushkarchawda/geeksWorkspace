package practice.java;

/**
 * Dynamic Method Dispatch or Runtime Polymorphism in Java 2.2 Prerequisite:
 * Overriding in java, Inheritance
 * 
 * Method overriding is one of the ways in which Java supports Runtime
 * Polymorphism. Dynamic method dispatch is the mechanism by which a call to an
 * overridden method is resolved at run time, rather than compile time.
 * 
 * When an overridden method is called through a superclass reference, Java
 * determines which version(superclass/subclasses) of that method is to be
 * executed based upon the type of the object being referred to at the time the
 * call occurs. Thus, this determination is made at run time. At run-time, it
 * depends on the type of the object being referred to (not the type of the
 * reference variable) that determines which version of an overridden method
 * will be executed A superclass reference variable can refer to a subclass
 * object. This is also known as upcasting. Java uses this fact to resolve calls
 * to overridden methods at run time.
 * 
 * @author PUSHKAR CHAWDA - reference by geekforgeeks.com
 *
 */

class A {
	int x = 10;

	void m1() {
		System.out.println("Inside A's m1 method");
	}
}

class B extends A {
	int x = 20;

	// overriding m1()
	void m1() {
		System.out.println("Inside B's m1 method");
	}
}

class C extends A {
	int x = 30;

	// overriding m1()
	protected void m1() {
		System.out.println("Inside C's m1 method");
	}
}

class D {
	int x = 30;

	// overriding m1()
	void m1() {
		System.out.println("Inside D's m1 method");
	}
}

class E extends C {
	int x = 30;

	// overriding m1()
	public void m1() {
		System.out.println("Inside D's m1 method");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		A a = new A(); // object of type A reference of type A
		B b = new B(); // object of type B reference of type B
		C c = new C(); // object of type C reference of type C
		D d = new D(); // object of type D reference of type D

		/*
		 * MUST READ
		 * 
		 * Only superClass reference type which is 'a', can hold itself and sub
		 * class object A or B or C, vice versa gives compile issue.
		 * 
		 * ref.m1(); - will make call to the method m1() whose object is being
		 * hold by reference ref which is of A, hence for A it call's A.m1() for
		 * B call goes to b.m1(), for C c.m1() is called.
		 * 
		 * B and C is subclass of A since they inherit(extends) A, A is
		 * superClass of B and C.
		 * 
		 * D is neither subclass - as it doesn't inherit(extends) any Class nor
		 * superClass as any other class doesn't inherit(extends) D.
		 * 
		 */

		A ref; // reference variable 'a' reference type of 'A'
		ref = a; // ref refers to an A object
		ref.m1(); // calling A's version of m1()
		System.out.println(ref.x);
		ref = b; // now ref refers to a B object
		ref.m1(); // calling B's version of m1()
		System.out.println(ref.x);
		ref = c; // now ref refers to a C object
		ref.m1(); // calling C's version of m1()
		System.out.println(ref.x);

		/*
		 * MUST READ
		 * 
		 * ref = d; ref.m1();
		 * 
		 * COMPILE ISSUE : Now reference ref refer to D's object, this is
		 * compile error as D is not subclass of A so reference of A can't hold
		 * D's object.
		 * 
		 */

		/*
		 * MUST READ
		 * 
		 * System.out.println(ref.x);
		 * 
		 * above statement gives same result for all three as runtime
		 * polymorphism cannot be achieved by data members.
		 * 
		 * All the time A's data member will be called as reference type is of
		 * A.
		 * 
		 */

		/*
		 * MUST READ
		 * 
		 * Access Specifier -
		 * 
		 * Class A - A's method m1 is of default type. Class B - B's method m1
		 * is of default type. Class C - C's method m1 is of protected type.
		 * Class E - E's method m1 is of public type
		 * 
		 * lets '->' means X extends Y; if you have observed,
		 * 
		 * B -> A, C-> A, E -> C
		 * 
		 * hence access specifier of method m1() which is getting overridden is
		 * changing from "default -> protected -> public" which is Widening or
		 * Automatic Type Conversion
		 * 
		 * if you will try narrowing for methods
		 * "default <- protected <- public", it will give compile error.
		 * 
		 * Narrowing for data members are allowed for which we use Type Casting
		 * which is nothing but forcefully narrowing of object.
		 * 
		 */

	}

}
