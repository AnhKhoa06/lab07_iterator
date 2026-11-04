package ex7;

import java.util.Iterator;

/**
 * Represents a performance that can take place in a theater.
 * All implementations of this interface should be immutable.
 */
public interface Show extends Iterable<Show> {

	/** @return A description of the show. */
	String description();

	/** @return The running time of the show, in minutes. */
	int runningTime();

	/** @return A deep copy of the show. */
	Show copy();

	/**
	 * @return An iterator over the shows contained in this show. A show that is
	 *         not a composite contains no other show, so its iterator is empty.
	 */
	@Override
	Iterator<Show> iterator();
}