package threading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

	private static BlockingQueue<Integer> queue = null;

	Producer(BlockingQueue<Integer> queue) {

		//Thread.currentThread().setName(name);
		this.queue = queue;

	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random r = new Random();
			try {
				int i = r.nextInt(100);
				this.queue.put(i);
				System.out.println(Thread.currentThread().getName()+" produced "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Consumer implements Runnable {
	
	private static BlockingQueue<Integer> queue = null;

	Consumer(BlockingQueue<Integer> queue) {

		//Thread.currentThread().setName(name);
		this.queue = queue;

	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println(Thread.currentThread().getName()+" consumed "+this.queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class ProducerConsumerUsingBlockedQueue {
	
	public static void main(String args[])
	{
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

		System.out.println("Start Program");
		
		Thread t1 = new Thread(new Producer(queue));
		t1.setName("Producer");
		t1.start();
		Thread t2 = new Thread(new Consumer(queue));
		t2.setName("Consumer");
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End Program");
		
	}

}
