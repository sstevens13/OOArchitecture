package MVC;

public class PedestrianLightView implements Observer {

	public void update(LightsModel model) {
		System.out.println("Pedestrian Light:  WALK: " + model.getPedestrianWalk() + ", Don't Walk: " + model.getPedestrianDontWalk()+"\n");
	}

}
