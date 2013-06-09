package MVC;

public class TrafficLightView implements Observer {
	
	public void update(LightsModel model) {
		System.out.println("Traffic Light:     Red: " + model.getTrafficRed() + ", Yellow: " + model.getTrafficYellow() + ", Green: " + model.getTrafficGreen() +"\n");
	}
	
}
