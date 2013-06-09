package userInterface;

import hardware.Hardware;
import hardware.Subsystem;
import machineControl.MachineControl;

public class TestPhFMM {
	public static MachineControl mc;
	
	public static void main(String[] args) throws Exception {
		mc = new MachineControl(new Hardware(new Subsystem("pressure", 0, 200), 
				new Subsystem("current", 0, 200)));
		
		mc.executeRecipe("hw3_recipe1.csv");
		mc.executeRecipe("HW3_ConstantCurrent.csv");
		mc.executeRecipe("HW3_Ramp.csv");
		
		mc.setControlValue("current", -5);
		System.out.println(mc.getControlValue("current"));
		mc.setDuration(50);
		System.out.println(mc.getDuration());
		mc.setControlValue("pressure", 500);
		System.out.println(mc.getControlValue("pressure"));
		mc.manualRun();
	}
	
}
