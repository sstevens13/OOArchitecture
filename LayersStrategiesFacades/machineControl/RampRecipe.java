package machineControl;

import hardware.Hardware;

public class RampRecipe implements Recipe {
	private Hardware hardware;
	private int widgetSize;
	private int duration;
		
	protected RampRecipe(Hardware hardware, int widgetSize) throws Exception {
		this.hardware = hardware;
		this.widgetSize = widgetSize;
		this.duration = 30;
		if (widgetSize < 50 || widgetSize > 100) {
			throw new Exception("Bad part size");
		}
	}
	
	public boolean updateHardware(int time) {
		if (time <= duration) {
			if (time <= 10) {
				hardware.setSubsystemValue("pressure", time * 10);
			} 
			hardware.setSubsystemValue("current", widgetSize + 20 * time);
			return true;
		} else {
			return false;
		}
	}
	
}
