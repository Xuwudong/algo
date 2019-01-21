package stack;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyQueueTest {
	private MyQueue mq = new MyQueue();

	@Test
	public void testPush() {
		mq.push(1);
		assertEquals(false, mq.empty());
		assertEquals(1, mq.peek());
	}

	@Test
	public void testPop() {
		mq.push(2);
		int value = mq.pop();
		assertEquals(2,value);
		assertEquals(true,mq.empty());
	}

}
