package behaviour.observer;

public class MainRun {

	public static void main(String[] args) {
		
		Weather w = new Weather();
		LCDDisplay l = new LCDDisplay();
		PhoneDisplay p = new PhoneDisplay();
		System.out.println("Registered Phone and LCD");
		w.add(l);
		w.add(p);
		w.triggerUpdate();
		System.out.println("Un-registered Phone");
		w.remove(l);
		w.triggerUpdate();
		System.out.println("Un-registered LCD");
		w.remove(p);
		w.triggerUpdate();
		
	}

}
