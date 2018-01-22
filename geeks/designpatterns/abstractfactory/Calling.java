package abstractfactory;
public class Calling {
	
	public static void main(String args[])
	{
		AbstractFactory a = AbstractFactory.getFactoryObject(Architecture.HP);
		a.createCPU();
	}

}
