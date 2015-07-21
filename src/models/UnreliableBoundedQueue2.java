package models;

import java.util.Random;

import tests.JUnit_BoundedQueueSpecification;

/**
 * The same behaviour as the {@link ReliableBoundedQueue} except that there is
 * a random problematic delay on the execution of the {@link ReliableBoundedQueue#head} 
 * method that results in the performance of the queue no longer being acceptable 
 * - as defined in the test {@link JUnit_BoundedQueueSpecification#test_performance()}.
 * @author J Paul Gibson
 * @version 1
 *
 */
public class UnreliableBoundedQueue2 extends ReliableBoundedQueue{

	/**
	 * How often, on average, the {@link UnreliableBoundedQueue1#head}  method has a problematic delay.<br>
	 * Every time head is called, there is a probability of
	 * <code>  1/HEAD_PROBLEM_FREQ </code>
	 * that the execution is delayed by {@link UnreliableBoundedQueue1#DELAY} milliseconds.
	 */
	private  static int HEAD_PROBLEM_FREQ = 10000;
	
	/**
	 * The number of milliseconds that occur when there is a delay problem in
	 * the method {@link UnreliableBoundedQueue1#head}
	 */
	private static long DELAY = 10;
	
	public UnreliableBoundedQueue2(int bound) throws IllegalArgumentException{
		
		super(bound);
	}
	
	/**
	 * There is a probability of
	 * <code>  1/HEAD_PROBLEM_FREQ </code>
	 * that the execution of the head method is delayed by <code> DELAY </code> milliseconds.
	 */
	public int head (){
		Random RNG = new Random();
		if (RNG.nextInt(HEAD_PROBLEM_FREQ)==0)
			try  {Thread.sleep(DELAY);}catch (InterruptedException ie){};
		return super.head();
	}
}
