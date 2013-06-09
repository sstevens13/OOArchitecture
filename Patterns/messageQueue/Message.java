package messageQueue;

abstract class Message {
	private final String messageText;
	
	public Message(String messageText) {
		this.messageText = messageText; 
	}
	
	public String toString() {
		return messageText;
	}

}
