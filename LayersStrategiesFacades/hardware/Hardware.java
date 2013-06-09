package hardware;

public class Hardware {
	private Subsystem[] subsystems;
	
	/*
	 * maxTime is the maximum seconds a process can run
	 */
	public Hardware(Subsystem... subystems) {
		this.subsystems = subystems;
	}
	
	public void setSubsystemValue(String subsystemName, int value) {
		for (Subsystem subsystem : subsystems) {
			if (subsystem.toString().equals(subsystemName)) {
				subsystem.setCurrentValue(value);
			}
		}
	}
	
	/*
	 * returns subsystem's current control value
	 * 
	 * returns null if hardware is not running or subsystem doesn't exists
	 */
	public Integer getSubsystemValue(String subsystemName) {
		for (Subsystem subsystem : subsystems) {
			if (subsystem.toString().equals(subsystemName)) {
				return subsystem.getCurrentValue();
			}
		}
		return null;
	}
	
}
