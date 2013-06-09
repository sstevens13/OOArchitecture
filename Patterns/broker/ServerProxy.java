package broker;

public class ServerProxy extends Proxy {
	private Server server;
	
	public ServerProxy(String proxyID) {
		super(proxyID);
		server = new Server();
	}
	
	public void receiveMessage(CallMessage message) {
		CallMessage returnMessage = null;
		if (message.getMethodName().equals("addIntegers")) {
			String[] values = message.getParameters().split(",");
			int sum = server.addIntegers(Integer.parseInt(values[0].trim()), Integer.parseInt(values[1].trim()));
			returnMessage = new CallMessage(message.getSource(), message.getTarget(), "addIntegersReturnValue", sum+"", "int");
		} else if (message.getMethodName().equals("getLength")) {
			int length = server.getLength(message.getParameters());
			returnMessage = new CallMessage(message.getSource(), message.getTarget(), "getLengthReturnValue", length+"", "int");
		}
		if (returnMessage != null) {
			getBroker().dispatchMessage(returnMessage);
		}
	}

}
