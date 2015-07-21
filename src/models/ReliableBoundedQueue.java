package models;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import abstractions.BoundedQueueSpecification;


/**
 * Implements {@link BoundedQueueSpecification} interface using the generic library class 
 * {@link ConcurrentLinkedQueue}
 * @author J Paul Gibson
 */
public class ReliableBoundedQueue  implements BoundedQueueSpecification {
	
	
/*
 *  The maximum number of elements that the Queue can contain - cannot be changed once initialised
 */
private static int SIZE;

/*
 * The number of elements that are currently stored on the stack
 */
private int numberOfElements;


private ConcurrentLinkedQueue <Integer> queue;

/**
 * Constructs an empty (bounded) queue of integers
 * @param sizeBound specifies the maximum SIZE of the queue to be constructed
 * @throws IllegalArgumentException if the specified SIZE is not a positive integer
 */
public ReliableBoundedQueue (int sizeBound) throws IllegalArgumentException{
   if (sizeBound<1) throw new IllegalArgumentException("The size of the queue must be a postive integer"); 
   SIZE = sizeBound;
   numberOfElements=0;
   queue = new ConcurrentLinkedQueue<Integer>();
}

public void push (int x){
  if (is_full()) throw new IllegalStateException("Cannot push onto a queue that is full");
  queue.add(x); numberOfElements++;
}

public int head (){
  if (is_empty()) throw new IllegalStateException("Cannot read the head of a queue that is empty");
  return queue.peek();
}

public void pop (){
   if (is_empty()) throw new IllegalStateException("Cannot pop the head of a queue that is empty");
   queue.remove(); numberOfElements--;
}

/**
 * Generate a string representation of the queue of the form:<br>
 * Q: 1 2 3 
 */
public String toString(){
 
	String str = "Q: ";
	Iterator <Integer> iterator = queue.iterator();
	while (iterator.hasNext()) str = str+ iterator.next()+" ";
	return str;
}


public boolean is_full() {
	return (numberOfElements==SIZE);
}


public boolean is_empty() {
	return (numberOfElements ==0);
}

public int get_size() {
	return SIZE;
}

public boolean invariant() {
	return (numberOfElements<=SIZE) && (SIZE>=1);
}



}


