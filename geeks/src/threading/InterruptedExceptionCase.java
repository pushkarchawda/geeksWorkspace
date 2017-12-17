package threading;


class Interrupted implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" " + i);
			
			if(Thread.interrupted()) 
			{
				
				System.out.println("I'm about to stop");
				return;
			}

		}
	}
}

public class InterruptedExceptionCase {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Interrupted());
		t1.start();
		
		Thread t2 = new Thread(new Interrupted());
		t2.start();
		
		t2.interrupt();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Ends");
		
		
	}

}