import java.util.*;
import java.util.concurrent.*;

public class Test02 {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		
		ConcurrentHashMap<String, Double> hm = new ConcurrentHashMap<>();
		ConcurrentHashMap<String, Integer> mm =  new ConcurrentHashMap<>();;

		@Override
		public void putNewPrice(String symbol, double price) {
			
			if(hm.contains(symbol))
			{
				double x = hm.get(symbol);
				hm.put(symbol, price+x);
			}
			else
			{
				hm.put(symbol, price);
			}
			
			if(mm.contains(symbol))
			{
				int x = mm.get(symbol);
				mm.put(symbol, x+1);
			}
			else
			{
				mm.put(symbol, 1);
			}
		}

		@Override
		public double getAveragePrice(String symbol) {

			if(hm.contains(symbol))
			{
				double d = hm.get(symbol);
				int e = mm.get(symbol);
				return d/e;
			}
			
			return 0;
		// YOUR CODE HERE
		}

		@Override
		public int getTickCount(String symbol) {
			return mm.get(symbol);
		// YOUR CODE HERE
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}