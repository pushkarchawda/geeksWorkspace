package structural.decorator;

public class Tea implements Beverage {

	@Override
	public String desc() {
		return "Tea";
	}

	@Override
	public int cost() {
		return 10;
	}

}
