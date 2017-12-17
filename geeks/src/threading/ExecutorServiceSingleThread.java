package threading;

import java.util.concurrent.*;

public class ExecutorServiceSingleThread{

	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(3);
		
		Runnable task = new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
			
		};
		
		for(int i = 0;i<5;i++)
		{
			ex.execute(task);
		}
		
		ex.shutdown();
		
		
	}

}
