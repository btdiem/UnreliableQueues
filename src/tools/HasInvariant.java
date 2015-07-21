package tools;

/**
 * Interface for classes that have invariant method implemented
 * 
 * @author J Paul Gibson
 *
 */
public interface HasInvariant {

	/**
	 * 
	 * @return if the object is in a safe (meaningful) state
	 */
	public boolean invariant();
}
