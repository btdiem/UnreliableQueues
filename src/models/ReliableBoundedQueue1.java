package models;

import abstractions.BoundedQueueSpecification;
/**
 * 
 * The same behaviors with {@link UnreliableBoundedQueue1} except stopping the delaying thread
 * to guaranty the testing time </br>
 * 
 * @author btdiem </br>
 *
 */
public class ReliableBoundedQueue1 extends UnreliableBoundedQueue1 implements BoundedQueueSpecification{

	public ReliableBoundedQueue1(int bound) throws IllegalArgumentException {
		super(bound);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void push(int x) {
		
		super.push(x);
		Thread.currentThread().interrupt();
		
	}
	

}
