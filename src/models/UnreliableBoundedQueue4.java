package models;

import java.util.Random;

/**
 * The same behaviour as the {@link ReliableBoundedQueue} except that 
 * when the queue becomes full the service is disabled 
 * for a random period of time (between 100 and 500 milliseconds)<br>
 * When disabled,  method calls which can update the state (i.e. <code> push</code> and <code>pop</code>)
 * result in an {@link IllegalStateException}
 * @author J Paul Gibson
 * @version 1
 */
public class UnreliableBoundedQueue4 extends ReliableBoundedQueue{

	boolean disabled;
	long time2enable;
	
	public UnreliableBoundedQueue4(int sizeBound) throws IllegalArgumentException {
		
		super(sizeBound);
		disabled = false;
		time2enable = System.currentTimeMillis();	
	}
	
	public void  pop ()throws IllegalStateException{
		
		if (time2enable < System.currentTimeMillis()) disabled = false;
		if (disabled) throw new IllegalStateException("queue service is disabled for state updates");
		super.pop();
		
	}
	
	public void push (int x) throws IllegalStateException{
		
		if (time2enable < System.currentTimeMillis()) disabled = false;
		if (disabled) throw new IllegalStateException("queue service is disabled for state updates");
		
		super.push(x);
		if (is_full()){
			Random RNG = new Random();
			time2enable = System.currentTimeMillis() + 100 + RNG.nextInt(400);
			disabled = true;
		}
		
	}

}
