package structural.decorator;

public class Milk implements WrapperBeverage {
	Beverage b;
	
	Milk(Beverage b)
	{
		this.b = b;
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return this.b.desc()+" Milk";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.b.cost() + 5;
	}

}
