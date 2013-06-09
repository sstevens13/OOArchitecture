Programming Language = JAVA
Homework 4: MVC
6/8/2013

Changed the output slightly. I assumed that it is safer to link the pedestrian 
light for a road with the light controlling traffic on that same road. Thus, 
when a light is green, pedestrians shouldn't be crossing that street, etc.

After the model notifies all observers, it calls runTest() to make sure
that the state of the lights are not in conflict.