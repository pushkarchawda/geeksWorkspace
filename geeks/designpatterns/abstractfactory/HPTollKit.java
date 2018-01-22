package abstractfactory;

public class HPTollKit extends AbstractFactory{

	@Override
	CPU createCPU() {
		// TODO Auto-generated method stub
		System.out.println("HP CPU");
		return new HP_CPU();
	}

	@Override
	Monitor createMonitor() {
		// TODO Auto-generated method stub
		System.out.println("HP MONITOR");
		return new HP_Monitor();
	}

}
