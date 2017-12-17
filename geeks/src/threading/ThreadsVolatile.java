package threading;

import java.util.Scanner;

/**
 * If you will go through below code normally it is working but on some system
 * threads caches the 'running' variable and hence it will never gets shutdown
 * as the running will always be "true", the caching happens as the shutdown is
 * not declared inside 'run' method and hence the process things that it's value
 * is never going to change.
 * 
 * For this type of cases "VOLATILE" is introduced in java hence it tells the
 * keyword tells the processes that the value should not be cached and may
 * change in between the excution on program.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

class Process extends Thread {

	//private boolean running = true; // this is working here but below way is best approach
	private volatile boolean running = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}

public class ThreadsVolatile {

	public static void main(String args[]) {
		// Thread t1 = new Thread(new Process());
		Process t1 = new Process();
		t1.start();

		// lets take a Scanner object which waits till return is pressed on
		// console and shutdown
		// the thread by calling 'shutdown' method and
		//

		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		t1.shutdown();
		sc.close();

	}

}
