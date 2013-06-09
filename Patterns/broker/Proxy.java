package broker;

public abstract class Proxy {
	private final String proxyId;
	private final Broker broker;
	
	public Proxy(String proxyID) {
		this.proxyId = proxyID;
		broker = new Broker(proxyID, this);
	}
	
	public abstract void receiveMessage(CallMessage message);

	public String getProxyId() {
		return proxyId;
	}

	public Broker getBroker() {
		return broker;
	}
	
	
}
