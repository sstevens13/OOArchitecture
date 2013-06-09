package machineControl;

public class ManualRun implements Recipe {
	private int duration;

	protected ManualRun(int duration) {
		this.duration = duration;
	}
	
	/*
	 * only sets ControlValues on Hardware start 
	 */
	public boolean updateHardware(int time) {
		if (time <= duration) {
			return true;
		} else {
			return false;
		}
	}
}
