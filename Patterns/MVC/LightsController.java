package MVC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LightsController implements Observer {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private LightsModel model;
	
	public LightsController(LightsModel model) {
		this.model = model;
	}
	
	public void getUserInput() {
		System.out.println("Press <enter> to change light.");
		try {
			input.readLine();
			System.out.println("Status: ");
			model.advanceLight();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(LightsModel model) {
		this.model = model;
	}
	
}
