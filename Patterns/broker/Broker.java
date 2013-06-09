package broker;

import java.util.LinkedList;
import java.util.List;

public class Broker {
	private static List<Broker> brokers = new LinkedList<Broker>();
	//the name should reflect the related client or server
	//i.e. client or Lab 2 Broker
	private String brokerName; 
	private Proxy proxy;
	
	public Broker(String orbId, Proxy proxy) {
		this.brokerName = orbId;
		this.proxy = proxy;
		brokers.add(this);
	}
	
	public void receiveStringData(String stringMessage) {
		proxy.receiveMessage(stringToMessage(stringMessage));
	}
	
	public void dispatchMessage(CallMessage message) {
		Broker destinationBroker = null;
		for (Broker broker : brokers) {
			if(message.getTarget().equals(broker.getOrbId())) {
				destinationBroker = broker;
			}
		}
		if (destinationBroker != null) {
			destinationBroker.receiveStringData(messageToString(message));
		} else {
			CallMessage errorMessage = errorToMessage(message.getSource(), "", "server \""+ message.getTarget() +"\" is not availabe", "string");
			proxy.receiveMessage(errorMessage);
		}
	}	
	
	private String messageToString(CallMessage message) {
		return message.getTarget() +"--||--"+ message.getSource() +"--||--"+ message.getMethodName() 
				+"--||--"+ message.getParameters() 
				+"--||--"+ message.getParameterTypes();
	}
	
	private CallMessage stringToMessage(String str) {
		String[] details = str.split("--\\|\\|--");
		return new CallMessage(details[0], details[1], details[2], details[3], details[4]);
	}
	
	private CallMessage errorToMessage(String target, String source, String parameters, String parameterTypes) {
		return new CallMessage(target, source, "error", parameters, parameterTypes);
	}

	public String getOrbId() {
		return brokerName;
	}
	
}
