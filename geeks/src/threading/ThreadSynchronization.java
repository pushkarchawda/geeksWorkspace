package threading;

/**
 * 
 * In this code you can understand use of JOIN and Synchronized.
 * 
 * JOIN method of Thread:
 * 
 * Comment the below asked part and check the result, you will see count is 0,
 * as the main process is getting executed first and ends first by printing and
 * hence you get 0 and after that the thread keeps incrementing the count which
 * we can't see and we are not printing that, after we introduce join with both
 * the reference t1 and t2, the main process waits for the threads to end and
 * after that it prints the count.
 * 
 * Synchronized keyword :
 * 
 * If you try running above code again and again some time you can see that the
 * total of count is different, it should be 2000 as both loop are running 1000
 * times but it is less than that, it happens because till the Thread 1
 * increment the count and write it back to count variable the Thread 2 also
 * reads the value and increment the old value, check below thread one also
 * reads the count
 * 
 * Thread 1 : count = 100 Thread 2 : count = 100 Thread 1 : count = 100 + 1
 * Thread 1 : count = 101 Thread 2 : count = 100 + 1 Thread 2 : count = 101
 * 
 * hence final count = 101 instead of 102, which is incorrect. since we have
 * used synchronized keyword in 'increment' method, hence if once thread try to
 * updated count it acquires the lock and hence till he sets the count = count +
 * 1 and comes out of 'increment' method other thread can't enter and hence we
 * get proper total count = 20000
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class ThreadSynchronization {

	private static int count = 0; // use of volatile will not work as this is not caching issue

	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {

		ThreadSynchronization t = new ThreadSynchronization();
		t.process();

	}

	private void process() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
				}
			}

		});

		t1.start();
		t2.start();

		// comment this block of code and check the result
		try {
			t1.join();
			System.out.println("X");
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// comment this block of code and check the result

		System.out.println("Count " + count);
	}

}
