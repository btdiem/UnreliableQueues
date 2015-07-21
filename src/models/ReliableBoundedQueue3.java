package models;

/**
 * 
 * The same behaviors with {@link UnreliableBoundedQueue3} except overriding {@link UnreliableBoundedQueue3#push(int)}
 * to guarantee the testing time </br>
 * 
 * 
 * @author btdiem </br>
 *
 */

public class ReliableBoundedQueue3 extends UnreliableBoundedQueue3 {

	ReliableBoundedQueue queueTemp;

	public ReliableBoundedQueue3(int bound) throws IllegalArgumentException {
		super(bound);
	}

	/**
	 * To avoid adding incorrect value, the current method will verify the queue after adding </br>
	 * If these values is not correct, do again until it is correct </br>
	 */
	@Override
	public void push(int x) {
		
		String toString = toString() + x + " ";

		super.push(x);
		
		if (!toString.equals(toString())){

			correctQueue(toString);
		}
		
	}

	/**
	 * 
	 * @param toString has format Q : 1 2 3
	 * Remove the queue and add again until these values in the queue are correct </br>
	 */
	private void correctQueue(String toString) {
		
		String[] numbers = toString.trim().split(" ");
		
		do{
			while(!is_empty()){
				pop();
			}
			
			for (int i=1; i< numbers.length; i++){
				super.push(Integer.valueOf(numbers[i]));
			}//for
			
		}while(!toString.equals(toString()));//do-while
	}


	
	
	

}
