package structural.decorator;

public class GetDrink {

	public static void main(String[] args) {

		Beverage b = new Tea();
		System.out.println("Simple Tea : "+b.desc()+", cost "+b.cost());
		Beverage bM = new Milk(b);
		System.out.println("Milk Tea : "+bM.desc()+", cost "+bM.cost());
		Beverage bC = new Coffee();
		Beverage bCMilkCream = new Milk(new Cream(bC));
		
		System.out.println("Milk Cream Coffee : "+bCMilkCream.desc()+", cost "+bCMilkCream.cost());
		
	}

}
