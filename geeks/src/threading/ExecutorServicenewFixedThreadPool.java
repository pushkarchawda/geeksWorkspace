package threading;

import java.util.concurrent.*;

public class ExecutorServicenewFixedThreadPool{

	public static void main(String[] args) {

		ExecutorService ex = Executors.newCachedThreadPool();
		
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
