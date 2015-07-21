package models;

/**
 * 
 * The same behaviors with {@link UnreliableBoundedQueue4} except overriding {@link UnreliableBoundedQueue4#pop()}
 * 
 * @author btdiem </br>
 *
 */

public class ReliableBoundedQueue4 extends UnreliableBoundedQueue4 {


	public ReliableBoundedQueue4(int sizeBound) throws IllegalArgumentException {
		super(sizeBound);
		// TODO Auto-generated constructor stub
	}

	/**
	 * when getting a {@link IllegalStateException}, try to delay the program about 500 ms that
	 * is caused to disable service
	 */
	@Override
	public void pop() throws IllegalStateException {
		
		try{
			super.pop();
		}catch(IllegalStateException e){
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			super.pop();
		}
		
	}

	

}
