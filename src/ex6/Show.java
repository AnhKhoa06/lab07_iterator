package ex6;

/**
 * Represents a performance that can take place in a theater.
 * All implementations of this interface should be immutable.
 */
public interface Show {

	/** @return A description of the show. */
	String description();

	/** @return The running time of the show, in minutes. */
	int runningTime();

	/** @return A deep copy of the show. */
	Show copy();
}