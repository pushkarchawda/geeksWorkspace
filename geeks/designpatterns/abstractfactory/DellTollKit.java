package abstractfactory;

public class DellTollKit extends AbstractFactory {

	@Override
	CPU createCPU() {
		// TODO Auto-generated method stub
		System.out.println("DELL CPU");
		return new DELL_CPU();
	}

	@Override
	Monitor createMonitor() {
		System.out.println("DELL MONITOR");
		// TODO Auto-generated method stub
		return new DELL_Monitor();
	}

}
