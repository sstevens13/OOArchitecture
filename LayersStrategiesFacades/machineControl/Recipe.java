package machineControl;

interface Recipe {
	/*
	 * returns false if the process is done
	 * 
	 * updates hardware values
	 */
	abstract boolean updateHardware(int time);
}
