package machineControl;

import hardware.Hardware;

public class ConstantCurrentRecipe implements Recipe {
	private Hardware hardware;
	private int widgetSize;
	private int duration;
		
	protected ConstantCurrentRecipe(Hardware hardware, int widgetSize) throws Exception {
		this.hardware = hardware;
		this.widgetSize = widgetSize;
		this.duration = 20;
		if (widgetSize < 0 || widgetSize > 100) {
			throw new Exception("Bad part size");
		}
	}

	public boolean updateHardware(int time) {
		if (time <= duration) {
			if (time == 0) {
				hardware.setSubsystemValue("current", widgetSize + 50);
				hardware.setSubsystemValue("pressure", 50);
			} else {
				hardware.setSubsystemValue("pressure", 50 - (time * 2));
			}
			return true;
		} else {
			return false;
		}
	}
}
