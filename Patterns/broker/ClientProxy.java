package broker;

public class ClientProxy extends Proxy {
	private String serverName = "";
	
	public ClientProxy(String proxyId) {
		super(proxyId);
	}
	
	public void addIntegers(int val1, int val2) {
		getBroker().dispatchMessage(new CallMessage(serverName, "client", "addIntegers", val1 + ", " + val2, "int, int"));
	}
	
	public void getLength(String str) {
		getBroker().dispatchMessage(new CallMessage(serverName, "client", "getLength", str, "string"));
	}

	public void receiveMessage(CallMessage message) {
		if (message.getMethodName().equals("error")) {
			System.out.println(message.getParameters() +"\n");
		} else if (message.getMethodName().equals("addIntegersReturnValue")) {
			System.out.println("Sum is equal to: " + String.valueOf(message.getParameters()) +"\n");
		} else if (message.getMethodName().equals("getLengthReturnValue")) {
			System.out.println("String Length is: " + String.valueOf(message.getParameters()) +"\n");
		}		
	}
	
	public void setServer(String serverName) {
		if (serverName != null) {
			this.serverName = serverName;
		}
	}
	
}
