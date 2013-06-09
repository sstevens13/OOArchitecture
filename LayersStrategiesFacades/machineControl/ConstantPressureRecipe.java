package machineControl;

import hardware.Hardware;

public class ConstantPressureRecipe implements Recipe {
	private Hardware hardware;
	private int widgetSize;
	private int duration;
		
	protected ConstantPressureRecipe(Hardware hardware, int widgetSize) throws Exception {
		this.hardware = hardware;
		this.widgetSize = widgetSize;
		this.duration = 10;
		if (widgetSize < 0 || widgetSize > 100) {
			throw new Exception("Bad part size");
		}

	}

	public boolean updateHardware(int time) {
		if (time <= duration) {
			if (time == 0) {
				hardware.setSubsystemValue("pressure", widgetSize + 100);
				hardware.setSubsystemValue("current", 0);
			} else {
				hardware.setSubsystemValue("current", time * 2);
			}
			return true;
		} else {
			return false;
		}
	}
}
