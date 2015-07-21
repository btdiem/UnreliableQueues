package tests;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import abstractions.BoundedQueueSpecification;

/**
 * Unit tests for checking bounded queue behaviour as 
 * specified by {@link BoundedQueueSpecification}
 * @author J Paul Gibson
 *
 */
public abstract class JUnit_BoundedQueueSpecification {

	
	/**
	 * The bounded queue under test
	 */
	BoundedQueueSpecification boundedQ;
	
	/**
	 * This method needs to construct a concrete instance of a bounded queue to be tested.
	 * This should be an empty queue with the maximum bound set to be 3.
	 * @throws Exception
	 */
	@Before
	public abstract void setUp() throws Exception;
		
	@After
	public void tearDown() throws Exception {
		boundedQ = null;
	}
	
	@Test 
	public void test_is_empty(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());

		boundedQ.push(1);
		Assert.assertFalse(boundedQ.is_empty());
	}
	
	@Test 
	public void test_is_full(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());
		
		Assert.assertFalse(boundedQ.is_full());
		boundedQ.push(1);
		boundedQ.push(2);
		boundedQ.push(3);
		Assert.assertTrue(boundedQ.is_full());
	}
	
	@Test 
	public void test_get_size(){
		Assert.assertEquals(3, boundedQ.get_size());
	}
		
	
	@Test (expected = IllegalStateException.class)
	public void test_headKO(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());
		
		boundedQ.head();
	}
	
	@Test (expected = IllegalStateException.class)
	public void test_popKO(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());
		
		boundedQ.pop();
	}
	
	@Test (expected = IllegalStateException.class)
	public void test_pushKO(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());
		
		boundedQ.push(1);
		boundedQ.push(2);
		boundedQ.push(3);
		boundedQ.push(4);
	}
	
	@Test
	public void test_head(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());
		
		boundedQ.push(1);
		boundedQ.push(2);
		boundedQ.push(3);
		Assert.assertEquals(1, boundedQ.head());
		boundedQ.pop();
		boundedQ.pop();
		Assert.assertEquals(3, boundedQ.head());
	}
	
	
	@Test
	public void test_pop(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());
		
		boundedQ.push(1);
		boundedQ.push(2);
		boundedQ.push(3);
		boundedQ.pop();
		Assert.assertEquals(2, boundedQ.head());
		Assert.assertTrue(!boundedQ.is_empty());
		Assert.assertTrue(!boundedQ.is_full());
		boundedQ.pop();
		Assert.assertEquals(3, boundedQ.head());
		Assert.assertTrue(!boundedQ.is_empty());
		Assert.assertTrue(!boundedQ.is_full());
		boundedQ.pop();
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertTrue(!boundedQ.is_full());
	}
	
	@Test
	public void test_push(){
		Assert.assertTrue(boundedQ.is_empty());
		Assert.assertEquals(3, boundedQ.get_size());
		
		boundedQ.push(1);
		Assert.assertEquals(1, boundedQ.head());
		Assert.assertTrue(!boundedQ.is_empty());
		Assert.assertTrue(!boundedQ.is_full());
		boundedQ.push(2);
		Assert.assertEquals(1, boundedQ.head());
		Assert.assertTrue(!boundedQ.is_empty());
		Assert.assertTrue(!boundedQ.is_full());
		boundedQ.push(3);
		Assert.assertEquals(1, boundedQ.head());
		Assert.assertTrue(!boundedQ.is_empty());
		Assert.assertTrue(boundedQ.is_full());
	}
	

	

	
	/**
	 * Make a million calls to each of the bounded queue methods and check that
	 * the delay is no bigger than a second
	 */
	@Test
	public void test_performance(){
		
		long time1;
		long time2;
		time1 = System.currentTimeMillis();
		
		for (int i=0; i<1000000; i++){
			boundedQ.push(1);
		 	boundedQ.head();
			boundedQ.is_empty();
			boundedQ.is_full();
			boundedQ.get_size();
			boundedQ.pop();
		}
		
		time2 = System.currentTimeMillis();
		//System.out.println(time2-time1);
		Assert.assertTrue(time2-time1<1000);
	
	}
	
	
	@Test
	public void test_toString(){
		Assert.assertEquals("Q: ", boundedQ.toString());
		boundedQ.push(1);
		Assert.assertEquals("Q: 1 ", boundedQ.toString());
		boundedQ.push(2);
		Assert.assertEquals("Q: 1 2 ", boundedQ.toString());
		boundedQ.push(3);
		Assert.assertEquals("Q: 1 2 3 ", boundedQ.toString());
	}
}
