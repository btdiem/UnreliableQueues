package tests;

import junit.framework.Assert;
import models.ReliableBoundedQueue2;


public class JUnit_UnreliableBoundedQueue2 extends JUnit_ReliableBoundedQueue{

	public void setUp() throws Exception {
		//boundedQ = new UnreliableBoundedQueue2(3);
		boundedQ = new ReliableBoundedQueue2(3);
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());	
	}
	
}
