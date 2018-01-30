package behaviour.observer;

public class LCDDisplay implements Observer {
	
	@Override
	public void update() {

		System.out.println("LCD Display Called");

	}

}
