package behaviour.observer;

import java.util.ArrayList;

public class Weather implements Observable {
	
	public ArrayList<Observer> a;
	

	Weather()
	{
		this.a = new ArrayList<Observer>();
	}
	
	@Override
	public void add(Observer a) {
		// TODO Auto-generated method stub
		this.a.add(a);

	}

	@Override
	public void remove(Observer a) {
		// TODO Auto-generated method stub
		this.a.remove(a);

	}
	
	public void triggerUpdate()
	{
		for(Observer u : a)
		{
			u.update();
		}
	}

}
