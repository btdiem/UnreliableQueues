package tests;

import junit.framework.Assert;
import models.ReliableBoundedQueue4;

public class JUnit_UnreliableBoundedQueue4 extends JUnit_ReliableBoundedQueue{

	public void setUp() throws Exception {
		//boundedQ = new UnreliableBoundedQueue4(3);
		boundedQ = new ReliableBoundedQueue4(3);
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());	
	}
}