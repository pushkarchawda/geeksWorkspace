package abstractfactory;

public abstract class AbstractFactory {
	
	private static final DellTollKit d = new DellTollKit();
	private static final HPTollKit h = new HPTollKit();
	
	public static AbstractFactory getFactoryObject(Architecture a)
	{
		
		AbstractFactory af = null;
		
		switch(a)
		{
		case HP :  af = h;
				  break;
				 
		case DELL :  af = d;
				  break;
				
		}
		
		return af;
	}
	
	abstract CPU createCPU();
	abstract Monitor createMonitor();

}
