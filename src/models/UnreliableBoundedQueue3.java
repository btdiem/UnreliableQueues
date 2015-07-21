package models;

import java.util.Random;

import tests.JUnit_BoundedQueueSpecification;


/**
 * The same behaviour as the {@link ReliableBoundedQueue} except that there is
 * a random problematic error on the execution of the {@link ReliableBoundedQueue#push}
 * method that results in the least significant bit of the integer value received being flipped.
 * The unit test code defined in {@link JUnit_BoundedQueueSpecification}
 * has a probability of finding the error (when it occurs), depending on the frequency
 * of occurence.
 * @author J Paul Gibson
 * @version 1
 *
 */
public class UnreliableBoundedQueue3 extends ReliableBoundedQueue{

	/**
	 * How often, on average, the {@link UnreliableBoundedQueue1#push}  method has a problematic 
	 * error which flips the least significant bit of the data just recieved.<br>
	 * Every time push is called, there is a probability of
	 * <code>  1/PUSH_PROBLEM_FREQ </code>
	 * that the error occurs 
	 */
	private  static int PUSH_PROBLEM_FREQ = 10;
	static int count = 0;
	
	public UnreliableBoundedQueue3(int bound) throws IllegalArgumentException{
		
		super(bound);
	}
	
	/**
	 * There is a probability of
	 * <code>  1/PUSH_PROBLEM_FREQ </code>
	 * that the least significant bit of the integer being pushed is flipped
	 */
	public void push (int x){
		Random RNG = new Random();
		if (RNG.nextInt(PUSH_PROBLEM_FREQ)==0){
			//System.out.println("hehe");
			//count ++;
			if (x%2 ==0) 
				x++; 
			else 
				x--;
		}
		//System.out.println("count :" + count);
		super.push(x);
	}
	
	
}

