package threading;

import java.util.concurrent.*;

public class ExecutorServiceCachedThread{

	public static void main(String[] args) {

		ExecutorService ex = Executors.newCachedThreadPool();
		
		Runnable task = new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
			
		};
		
		for(int i = 0;i<1000;i++)
		{
			ex.execute(task);
		}
		
		ex.shutdown();
		
		try {
			ex.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All task done");
		
		
	}

}
