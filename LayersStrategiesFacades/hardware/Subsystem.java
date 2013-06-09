package hardware;

public class Subsystem {
	private String subsystemName;
	private int currentValue;
	private int minValue;
	private int maxValue;
	
	public Subsystem(String subsystemName, int min, int max) throws Exception {
		this.subsystemName = subsystemName;
		if (min > max) {
			throw new Exception("Bad min and max");
		} else {
			minValue = min;
			maxValue = max;
		}
	}
	
	public String toString() {
		return subsystemName;
	}

	protected int getCurrentValue() {
		return currentValue;
	}

	// sets the current value of the system
	protected void setCurrentValue(int newValue) {
		if (newValue < minValue) {
			currentValue = minValue;
		} else if (newValue > maxValue) {
			currentValue = maxValue;
		} else { 
			currentValue = newValue;
		}
	}

	protected int getMinValue() {
		return minValue;
	}

	protected int getMaxvalue() {
		return maxValue;
	}	
	
}
