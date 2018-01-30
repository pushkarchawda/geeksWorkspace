package structural.decorator;

public class Coffee implements Beverage {

	@Override
	public String desc() {
		return "Coffee";
	}

	@Override
	public int cost() {
		return 10;
	}

}
