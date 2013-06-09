package messageQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMessageQueue {

	private MessageQueue msgQueue;
	
	protected void setUp() {
		msgQueue = new MessageQueue();
		msgQueue.addMsg(new ReplyMsg("first reply"));
		msgQueue.addMsg(new ReplyMsg("second reply"));
		msgQueue.addMsg(new QueryMsg("first query"));
		msgQueue.addMsg(new ReplyMsg("third reply"));
		msgQueue.addMsg(new QueryMsg("second query"));
	}
	
	protected void tearDown() {
		msgQueue = null;
	}
	
	@Test
	public void testEmptyMsgQueue() {
		msgQueue = new MessageQueue();
		assertEquals("popMsg() should return null for empty queue", null, msgQueue.popMsg());
	}
	
	@Test
	public void testPopMsg() {
		setUp();
		assertTrue("first added message is the first returned message (i.e. fifo)",
				msgQueue.popMsg().toString().equals("first reply"));
		assertTrue("second added message is the first returned message (i.e. fifo)",
				msgQueue.popMsg().toString().equals("second reply"));
	}
	
	@Test
	public void testPopMsgTypes() {
		setUp();
		assertTrue("first Message is an instance of ReplyMessage", 
				msgQueue.popMsg() instanceof ReplyMsg);
		assertTrue("second Message is an instance of ReplyMessage", 
				msgQueue.popMsg() instanceof ReplyMsg);
		assertTrue("third Message is an instance of QueryMsg", 
				msgQueue.popMsg() instanceof QueryMsg);
		assertTrue("fourth Message is an instance of ReplyMessage", 
				msgQueue.popMsg() instanceof ReplyMsg);
		assertTrue("fifth Message is an instance of QueryMsg", 
				msgQueue.popMsg() instanceof QueryMsg);
		assertTrue("empy MessageQueue returns null", msgQueue.popMsg() == null);
	}

	@Test
	public void testPeek() {
		setUp();
		assertTrue(msgQueue.peek().toString().equals("first reply"));
		assertTrue(msgQueue.popMsg().toString().equals("first reply"));
		msgQueue.popMsg();
		msgQueue.popMsg();
		msgQueue.popMsg();
		msgQueue.popMsg();
		assertTrue("msgQueue should be empty, pop should return null", 
				msgQueue.peek() == null);
	}
	
}


//@Test
//public void testPopQueryMsg() {
//	setUp();
//	assertTrue("should return first query message",
//			msgQueue.popQueryMsg().toString().equals("first query"));
//	assertTrue("first added message shoudl be returned",
//			msgQueue.popMsg().toString().equals("first reply"));
//	assertTrue("should return second query message",
//			msgQueue.popQueryMsg().toString().equals("second query"));
//	assertTrue("should return null", msgQueue.popQueryMsg() == null);
//}
//
//@Test
//public void testPopReplyMsg() {
//	setUp();
//	msgQueue.popMsg();
//	msgQueue.popMsg();
//	assertTrue("should return third reply message",
//			msgQueue.popReplyMsg().toString().equals("third reply"));
//	assertTrue("should return null", msgQueue.popReplyMsg() == null);
//}
