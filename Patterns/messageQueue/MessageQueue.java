package messageQueue;

import java.util.Vector;

public class MessageQueue {
	private Vector<Message> vectorQueue = new Vector<Message>();
	
	
	public boolean addMsg(Message message) {
		return vectorQueue.add(message);
	}
	
	//*************************************************************************
	// removes first element of queue and returns it, returns null if empty
	//*************************************************************************
	public Message popMsg() {
		if (isEmpty() || vectorQueue == null) return null;
		return vectorQueue.remove(0);
	}
	
	//*************************************************************************
	// returns true if queue is empty
	//*************************************************************************
	public boolean isEmpty() {
		if (vectorQueue.size() > 0) {
			return false;
		}
		return true;
	}
	
	//*************************************************************************
	// returns first element without removing it, returns null if empty
	//*************************************************************************
	public Message peek() {
		if (isEmpty()) return null;
		return vectorQueue.elementAt(0);		
	}

}


////*************************************************************************
//// finds first instance of ReplyMsg and returns it, else returns null
////*************************************************************************
//public Message popReplyMsg() {
//	if (isEmpty()) return null;
//	Iterator<Message> iterator = vectorQueue.iterator();
//	Message msg = null;
//	while (iterator.hasNext()) {
//		msg = iterator.next();
//		if (msg instanceof ReplyMsg) {
//			iterator.remove();
//			return msg;
//		}
//	}
//	return null;
//}
//
////*************************************************************************
//// finds first instance of QueryMsg and returns it, else returns null
////*************************************************************************
//public Message popQueryMsg() {
//	if (isEmpty()) return null;
//	Iterator<Message> iterator = vectorQueue.iterator();
//	Message msg = null;
//	while (iterator.hasNext()) {
//		msg = iterator.next();
//		if (msg instanceof QueryMsg) {
//			iterator.remove();
//			return msg;
//		}
//	}
//	return null;
//}
