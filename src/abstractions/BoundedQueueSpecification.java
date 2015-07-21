package abstractions;

import tools.HasInvariant;


/**
 *
 * A FIFO bounded queue of integers with a maximum number of elements that must be at least 1.
 * 
 * @author J Paul Gibson
 * @version 1
 */
public interface BoundedQueueSpecification extends HasInvariant{

	
	/**
	 * 
	 * @return  if the queue is full, i.e. the number of elements in the queue is equal to the maximum 
	 * number allowed
	 */
	public boolean is_full();
	
	/**
	 * 
	 * @return if the queue is empty, i.e. the number of elements in the queue is equal to 0.
	 */
	public boolean is_empty();
	
	
	/**
	 * 
	 * @return the maximum number of elements that the queue can hold
	 */
	public int get_size();
	/**
	 * 
	 * @param x is the value being pushed onto queue, and which will become the
	 * element on the queue that has been there for the shortest time
	 * @throws IllegalStateException if we try to push onto a queue that is full
	 */
	public void push (int x) throws IllegalStateException;
	
	
	/**
	 * 
	 * @return  head of queue,
	 * where the head is the element that has been in the queue for the longest time.<br>
	 * Does not change the state of the queue
	 * @throws IllegalStateException if we try to read the head of an empty queue
	 */
	public int head () throws IllegalStateException;
	
	/**
	 *  remove head of queue if it is not empty,
	 *  where the head is the element that has been in the queue for the longest time
	 *  @throws IllegalStateException if we try to pop from an empty queue
	 */
	public void pop () throws IllegalStateException;
	
	/**
	 * 
	 * @return if the queue is in a safe state and respects the specified requirements:
	 * <ul>
	 * <li> the number of elements in the queue is no bigger than the maximum specified </li>
	 * <li> the maximum bound is a positive integer </li>
	 * </ul>
	 */
	public boolean invariant();
	
}
