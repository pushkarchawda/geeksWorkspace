package threading;

/**
 * 
 * One way to implement thread is to extend the THREAD Class
 * 
 * @author PUSHKAR CHAWDA
 *
 */

class FirstWay extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
		}
	}
}

public class FirstWayThreadClass {

	public static void main(String[] args) {

		FirstWay f1 = new FirstWay();
		f1.start();

		/*
		 * f1.start() vs f1.run()
		 * 
		 * f1.start will create a completely new stack and will run the 'run'
		 * method independently where as f1.run() will run in the same stack
		 * where 'main' method is running hence it is similar to calling a
		 * function in normal java terminology
		 * 
		 * 
		 */

		FirstWay f2 = new FirstWay();
		f2.start();

	}

}
