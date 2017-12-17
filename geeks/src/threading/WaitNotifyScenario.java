package threading;

class WaitNotify {

	public void one() {
		synchronized (this) {

			System.out.println(" ONE : I am currently awake..");
			System.out.println(
					" ONE : Now, I am going to wait till some thread notifies me.. and other thread will start");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void two() {
		synchronized (this) {

			System.out.println(" TWO : I am currently awake");
			notify();
			System.out.println(" TWO : Now, I am going to wait till for 10 sec and will notify thread one");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

public class WaitNotifyScenario extends Thread {

	public static void main(String args[]) {
		System.out.println("Start....");

		WaitNotify n = new WaitNotify();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					n.one();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					n.two();
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

		System.out.println("End....");

	}

}
