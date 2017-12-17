package threading;

public class DeadLock {
	
	Object lock1 = new Object();
	Object lock2 = new Object();

	 void bar() {
		synchronized (lock1) {
			synchronized (lock2) {
				System.out.println("BAR");
			}
		}
	}

	protected void foo() {
		synchronized (lock1) {
			synchronized (lock2) {
				System.out.println("FOO");
			}
		}
	}
	
	public void main()
	{
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					foo();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					bar();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Program Ends here....");
	}

	public static void main(String[] args) {

		DeadLock x = new DeadLock();
		x.main();

	}

}
