package machineControl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import hardware.Hardware;

public class MachineControl {
	private Hardware hardware;
	private Recipe recipe;
	private String firstLine;
	private String referenceName;
	private String fileName;
	private int duration = 0;
	
	// hardware is initially off
	private boolean running = false;
	
	/*
	 * maxTime is the maximum seconds a process can run
	 */
	public MachineControl(Hardware hardware) {
		this.hardware = hardware;
	}

	public void executeRecipe(String fileString) throws Exception {
		referenceName = fileString+".reference.csv";
		fileName = fileString.split("\\.")[0]+".DAS.csv";
		BufferedReader input = new BufferedReader(new FileReader(fileString));
		firstLine = input.readLine();
		input.close();
		String[] recipeArray = firstLine.split(",");
		
		int recipeWidget = Integer.parseInt(recipeArray[2].trim());
		if (recipeArray[1].equals("ConstantPressure")) {
			recipe = new ConstantPressureRecipe(hardware, recipeWidget);
		} else if (recipeArray[1].equals("ConstantCurrent")) {
			recipe = new ConstantCurrentRecipe(hardware, recipeWidget);
		} else if (recipeArray[1].equals("Ramp")) {
			recipe = new RampRecipe(hardware, recipeWidget);
		}
		
		start();
	}
	
	public void manualRun() throws IOException {
		fileName = "Manual.DAS.csv";
		firstLine = "Manual";
		recipe = new ManualRun(duration);		
		start();
	}
	
	/*
	 * only starts if the hardware is not currently running
	 */
	private void start() throws IOException {
		if (!running) {
			running = true;
			
		    FileWriter writer = new FileWriter(fileName);
		    writer.write(firstLine + "\n");
		    
			int currentSecond = 0;
			Long startTime = System.currentTimeMillis();
			while (running) {
				//can change to 10 from 1000 if the program should run in realtime
				if(System.currentTimeMillis() >= (currentSecond*1000 + startTime)) {
					if(recipe.updateHardware(currentSecond)) {
						writer.write(currentSecond +","+ hardware.getSubsystemValue("pressure")
								+","+ hardware.getSubsystemValue("current") +"\n");
						currentSecond += 1;
					} else {
						running = false;
					}
				}
			}
			writer.close();
			
			// validates process if it wasn't manual
			if (!fileName.contains("Manual.DAS.csv")) {
				BufferedReader outputReader = new BufferedReader(new FileReader(fileName));
				BufferedReader referenceReader = new BufferedReader(new FileReader(referenceName));
				
				String referenceLine;
				boolean goodPart = true;
				while ((referenceLine = referenceReader.readLine()) != null) {
					if (!referenceLine.equals(outputReader.readLine())) {
						goodPart = false;
						System.err.println("Bad Part!");
						break;
					}
				}
				// checks if the process wrote more lines than reference file
				if (goodPart) {
					if(outputReader.readLine() != null) {
						goodPart = false;
						System.err.println("Bad Part!");
					} else {
						System.out.println("Good Part!");
					}
				}
				outputReader.close();
				referenceReader.close();
				if (!goodPart) {
					BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileName, true));
					outputWriter.write("ERROR! File doesn't match reference.\n");
					outputWriter.close();
				}
			}
		} else {
			System.err.println("A process is already running");
		}
	}

	/*
	 * sets duration between 0 and 100
	 * setting mid process will not change duration of
	 * running process
	 */
	public void setDuration(int duration) {
		if (duration > 100) {
			this.duration = 100;
		} else if (duration < 0) {
			this.duration = 0;
		} else {
			this.duration = duration;
		}
	}
		
	public int getDuration() {
		return duration;
	}
	
	public void setControlValue(String subsystemName, int value) {
		if (!running){
			hardware.setSubsystemValue(subsystemName, value);
		}		
	}
	
	public Integer getControlValue(String subsystemName) {
		return hardware.getSubsystemValue(subsystemName);
	}	
}
