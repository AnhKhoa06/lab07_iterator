package ex7;

import java.util.Collections;
import java.util.Iterator;

/** A show that consists of the screening of a single movie. */
public class Movie implements Show {

	private final String aTitle;
	private final int aYear;
	private final int aRunningTime;

	public Movie(String pTitle, int pYear, int pTime) {
		aTitle = pTitle;
		aYear = pYear;
		aRunningTime = pTime;
	}

	@Override
	public String description() {
		return String.format("%s (%d)", aTitle, aYear);
	}

	@Override
	public int runningTime() {
		return aRunningTime;
	}

	@Override
	public Show copy() {
		return new Movie(aTitle, aYear, aRunningTime);
	}

	@Override
	public Iterator<Show> iterator() {
		return Collections.emptyIterator();
	}
}