package models;

/**
 * 
 * The same behaviors with {@link UnreliableBoundedQueue2} except stopping the delaying thread
 * to guaranty the testing time </br>
 * 
 * @author btdiem </br>
 *
 */
public class ReliableBoundedQueue2 extends UnreliableBoundedQueue2 {

	public ReliableBoundedQueue2(int bound) throws IllegalArgumentException {
		super(bound);
	}

	@Override
	public int head() {
		
		int value = super.head();
		Thread.currentThread().interrupt();
		return value;
	}
	
	

}
