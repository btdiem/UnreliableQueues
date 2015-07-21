package tools;

/**
 * <TT>InvariantBroken</TT> is raised when the invariant of a class is not true in
 * the current state of the instance
 */
public class InvariantBroken extends RuntimeException {

private static final long serialVersionUID = 1L;

/**
   * Constructor of the exception raised when invariants are broken
   * @param message is used to explain which part of the invariant has been broken
   */
  public InvariantBroken(String message) {
    super(message);
  }
}

