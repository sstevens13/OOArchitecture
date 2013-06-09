JAVA = programming language

- created three packages 
	- the Hardware class is the facade for the hardware layer
	- the MachineControl class is the facade for the machine control layer
	- the other classes are protected
	
- i chose to let the user enter any value for a subsystem, but subsystem will
  force values to min or max if outside of range
	
- to run the program faster, change 1000 to 10 in line 70 of MachineControl.java 
   if(System.currentTimeMillis() >= (currentSecond*1000 + startTime)) {
	       
- i chose to throw an uncaught exception when a recipe had a widgetSize was less 
  than min(0) or greater than max(100) (for all recipes, < 50 for Ramp), because 
  I think a system should throw a serious error/shut down when hardware is given
  bad part sizes 
- in manual, the system will round bad input values to nearest limit (high/low)
  
- 3 folders pertaining to packages ==> non-facade methods are protected or private

- assumed that the recipes and reference files were in the executable directory

- TestPhFMM.java uses the UI a bit