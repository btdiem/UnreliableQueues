package tests;

import junit.framework.Assert;
import models.ReliableBoundedQueue1;

public class JUnit_UnreliableBoundedQueue1 extends JUnit_ReliableBoundedQueue{

		public void setUp() throws Exception {
			//boundedQ = new UnreliableBoundedQueue1(3);
			boundedQ = new ReliableBoundedQueue1(3);
			Assert.assertTrue(boundedQ.is_empty());
			Assert.assertEquals(3, boundedQ.get_size());	
		}
}
