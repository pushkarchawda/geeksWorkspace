package threading;

import java.util.concurrent.*;

public class CallableExecutorServiceSingleThread{

	public static void main(String[] args) {

		ExecutorService ex = Executors.newFixedThreadPool(3);
		Callable<Integer> cal = new Callable<Integer>() {
			
			@Override
			public Integer call(){
				// TODO Auto-generated method stub
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return 100;
			}
		};
		
		Future<Integer> f = ex.submit(cal);
		
		try {
			System.out.println("Result "+f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ex.shutdown();

	}

}
