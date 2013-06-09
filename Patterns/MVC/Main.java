package MVC;

public class Main {
	private static LightsModel model = new LightsModel();
	
	public static void main(String[] args) {
		LightsController controller = new LightsController(model);
		
		model.attachObserver(new PedestrianLightView());
		model.attachObserver(new TrafficLightView());
		model.attachObserver(controller);
		
		while (true) {
			controller.getUserInput();
		}
	}
	
}
