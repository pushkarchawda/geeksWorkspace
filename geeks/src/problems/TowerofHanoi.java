package problems;

/* Discuss Towers of Hanoi puzzle. */

public class TowerofHanoi {

	static int flag1 = 0;
	static int flag2 = 0;
	static int flag3 = 0;

	public static void main(String[] args) {

		Stackk s1 = new Stackk();
		Stackk s2 = new Stackk();
		Stackk s3 = new Stackk();

		s1.push(3);
		s1.push(2);
		s1.push(1);
		s1.push(0);

		// s1.pop();
		//s1.print();

		towerHanoi(4, s1, s3, s2);
		/*if (!s2.isEmpty())
			s2.print();*/
		if (!s3.isEmpty())
			s3.print();

	}

	private static void towerHanoi(int i, Stackk org, Stackk dest, Stackk medi) {

		if (i == 1) {
			dest.push(org.pop());
			return;
		}
		towerHanoi(i - 1, org, medi, dest);
		dest.push(org.pop());
		towerHanoi(i - 1, medi, dest, org);
	}

}

class Stackk {

	int a[];
	int top;
	int size;

	Stackk() {
		a = new int[20];
		top = -1;
		size = 0;
	}

	boolean push(int x) {
		if (size == a.length)
			return false;

		if (size < a.length) {
			a[++top] = x;
			size++;
			return true;
		} else {
			System.out.println("Stack Overflow");
			return false;
		}
	}

	int pop() {
		if (size == 0) {
			System.out.println("Stack underflow");
			return -1;
		}

		int y = a[top];
		a[top] = 0;
		top--;
		size--;
		return y;
	}

	boolean isEmpty() {
		if (size == 0) {
			return true;
		} else
			return false;
	}

	int peek() {
		if (!isEmpty())
			return a[top];
		else
			return -1;
	}

	void print() {
		int count = size;
		while (count > 0) {
			System.out.println(a[count - 1]);
			count--;
		}
	}

}
