package MVC;

import java.util.ArrayList;

public class LightsModel implements Subject {
	private int lightsStatus;
	private ArrayList<Observer> observers;
	public static enum LIGHT_STATE { ON, OFF, FLASHING }
	
	public LightsModel() {
		lightsStatus = 0;
		observers = new ArrayList<Observer>();
	}
	
	public void advanceLight() {
		if (lightsStatus == 2) {
			lightsStatus = 0;
		} else {
			lightsStatus++;
		}
		notifyObservers();
	}
	
	public LIGHT_STATE getTrafficRed() {
		if (lightsStatus == 0) {
			return LIGHT_STATE.ON;
		} else if (lightsStatus == 1) {
			return LIGHT_STATE.OFF;
		} else {
			return LIGHT_STATE.OFF;
		}
	}
	
	public LIGHT_STATE getTrafficYellow() {
		if (lightsStatus == 0) {
			return LIGHT_STATE.OFF;
		} else if (lightsStatus == 1) {
			return LIGHT_STATE.OFF;
		} else {
			return LIGHT_STATE.ON;
		}
	}
	
	public LIGHT_STATE getTrafficGreen() {
		if (lightsStatus == 0) {
			return LIGHT_STATE.OFF;
		} else if (lightsStatus == 1) {
			return LIGHT_STATE.ON;
		} else {
			return LIGHT_STATE.OFF;
		}
	}
	
	public LIGHT_STATE getPedestrianWalk() {
		if (lightsStatus == 0) {
			return LIGHT_STATE.ON;
		} else if (lightsStatus == 1) {
			return LIGHT_STATE.OFF;
		} else {
			return LIGHT_STATE.OFF;
		}
	}
	
	public LIGHT_STATE getPedestrianDontWalk() {
		if (lightsStatus == 0) {
			return LIGHT_STATE.OFF;
		} else if (lightsStatus == 1) {
			return LIGHT_STATE.ON;
		} else {
			return LIGHT_STATE.FLASHING;
		}
	}
	
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}

	public void detachObserver(Observer observer) {
		observers.remove(observer);		
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
		runTest();
	}
	
	public void runTest() {
		int sumOn = 0;
		int sumOff = 0;
		if (getTrafficGreen() == LIGHT_STATE.ON) sumOn++;
		if (getTrafficYellow() == LIGHT_STATE.ON) sumOn++;
		if (getTrafficRed() == LIGHT_STATE.ON) sumOn++;
		if (getTrafficGreen() == LIGHT_STATE.OFF) sumOff++;
		if (getTrafficYellow() == LIGHT_STATE.OFF) sumOff++;
		if (getTrafficRed() == LIGHT_STATE.OFF) sumOff++;
		if (sumOn == 1 && sumOff == 2) {
			System.out.println("Test Good: one traffic light on, 2 traffic lights off");
		} else {
			System.err.println("Test Bad: there should be exactly one traffic light on, and 2 off");
		}
		if (getTrafficRed() == LIGHT_STATE.ON) {
			if (getPedestrianDontWalk() != LIGHT_STATE.OFF && getPedestrianWalk() != LIGHT_STATE.ON) {
				System.err.println("ERROR: Red on, but Walk is not On and/or Don't Walk is not Off");
			} else {
				System.out.println("Test Good: red on, walk on, don't walk off");
			}
		}
		if (getTrafficYellow() == LIGHT_STATE.ON) {
			if (getPedestrianDontWalk() != LIGHT_STATE.FLASHING && getPedestrianWalk() != LIGHT_STATE.OFF) {
				System.err.println("ERROR: Yellow On, but Don't Walk is not Flashing and/or Walk is not Off");
			} else {
				System.out.println("Test Good: yellow on, walk off, don't walk flashing");
			}
		}
		if (getTrafficGreen() == LIGHT_STATE.ON) {
			if (getPedestrianDontWalk() != LIGHT_STATE.ON && getPedestrianWalk() != LIGHT_STATE.OFF) {
				System.err.println("ERROR: Green On, but Walk is not Off and/or Don't Walk is not On");
			} else {
				System.out.println("Test Good: green on, walk off, don't walk on");
			}
		}
		System.out.println();
	}
	
}
