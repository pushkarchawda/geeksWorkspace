package structural.decorator;

public class Cream implements WrapperBeverage {

	Beverage b;
	
	Cream(Beverage b)
	{
		this.b = b;
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return this.b.desc()+" Cream";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return this.b.cost() + 15;
	}

}
