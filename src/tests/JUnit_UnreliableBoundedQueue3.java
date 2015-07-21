package tests;

import junit.framework.Assert;
import models.ReliableBoundedQueue3;

public class JUnit_UnreliableBoundedQueue3 extends JUnit_ReliableBoundedQueue{

	public void setUp() throws Exception {
		//boundedQ = new UnreliableBoundedQueue3(3);
		boundedQ = new ReliableBoundedQueue3(3);
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());	
	}
}
