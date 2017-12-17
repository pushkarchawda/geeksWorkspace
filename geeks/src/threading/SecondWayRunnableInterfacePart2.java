package threading;

/**
 * 
 * Second way to implement thread is to implements Runnable Interface and pass
 * SecondWay Class object into the constructor of THREAD Class while creating
 * Thread Class objects to implement Threading.
 * 
 * In this the extra Class is not needed and directly we can override 'run'
 * method while passing 'Runnable' object to constructor of 'Thread' Class
 * 
 * 
 * Explaining JOIN in this :
 * 
 * use of "JOIN" is that once u create a thread using THREAD or RUNNABLE and
 * call start method, then one more process starts in new process and hence
 * along with the main process one more process is present which we create using
 * THREAD or RUNNABLE, so main process will not wait and may ends first and the
 * other process may ends after that, which is not preferable all the time hence
 * joins helps you to let main class waits till all the process created in main
 * ends and then the main process.
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class SecondWayRunnableInterfacePart2 {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1; i++) {
					System.out.println("i = " + i);
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1; i++) {
					System.out.println("i = " + i);
				}
			}

		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1; i++) {
					System.out.println("i = " + i);
				}
			}

		});

		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1; i++) {
					System.out.println("i = " + i);
				}
			}

		});

		// Compare the results - 1

		System.out.println("Threading Starts");
		t1.start();
		t2.start();
		System.out.println("Threading Ends");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Compare the results - 2
		System.out.println("**************************************************");
		System.out.println("Threading Starts");
		t3.start();
		t4.start();
		System.out.println("Before join");
		try {
			t3.join();
			t4.join();
			System.out.println("After join");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Threading Ends");

	}

}
