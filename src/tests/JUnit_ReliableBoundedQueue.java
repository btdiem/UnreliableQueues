package tests;

import org.junit.Test;

import junit.framework.Assert;
import models.ReliableBoundedQueue;

public class JUnit_ReliableBoundedQueue extends JUnit_BoundedQueueSpecification{

	public void setUp() throws Exception {
		boundedQ = new ReliableBoundedQueue(3);
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_constructor_KO(){
		
		new ReliableBoundedQueue(-1);
	}

}
