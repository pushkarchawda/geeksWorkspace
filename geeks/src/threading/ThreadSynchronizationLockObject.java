package threading;

import java.util.*;
import java.util.Random;

class Worker {

}

public class ThreadSynchronizationLockObject {

	private Random random = new Random();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	private List<Integer> l1 = new ArrayList<Integer>();
	private List<Integer> l2 = new ArrayList<Integer>();

	public void addListOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l1.add(random.nextInt(100));
		}
	}

	public void addListTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l2.add(random.nextInt(100));
		}
	}

	public void process() {
		for(int i =0;i<1000;i++)
		{
			addListOne();
			addListTwo();
		}
		
	}

	public void main() {
		
		System.out.println("Starting....");
		
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}

		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
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
		
		long end = System.currentTimeMillis();
		
		System.out.println("Ends in "+(end-start));
		System.out.println("list1 size "+l1.size()+" list2 size "+l2.size());

	}
	
	public static void main(String[] args)
	{
		ThreadSynchronizationLockObject t = new ThreadSynchronizationLockObject();
		t.main();
	}

}
