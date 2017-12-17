package threading;

/**
 * 
 * Second way to implement thread is to implements Runnable Interface and pass
 * SecondWay Class object into the constructor of THREAD Class while creating Thread Class objects
 * to implement Threading.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

class SecondWay implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i = " + i);
		}
	}
}

public class SecondWayRunnableInterfacePart1 {

	public static void main(String[] args) {

		Thread t1 = new Thread(new SecondWay());
		t1.start();
		
		Thread t2 = new Thread(new SecondWay());
		t2.start();
	}

}
