package ex6;

import java.util.Iterator;

public class Exercise06 {

	private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
	private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
	private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);

	/** Prints the shows inside pShow if it is a composite. */
	private static void unpack(Show pShow) {
		if (pShow instanceof CompositeShow composite) {
			System.out.println("Unpacking: " + pShow.description());
			for (Show subshow : composite) {
				System.out.println("  - " + subshow.description());
			}
		} else {
			System.out.println("Not a composite show: " + pShow.description());
		}
	}

	public static void main(String[] args) {
		Show show = new CompositeShow(CONCERT, new CompositeShow(MOVIE1, MOVIE2));

		// 1. Unpack the outer composite, then the inner one
		unpack(show);
		for (Show subshow : (CompositeShow) show) {
			if (subshow instanceof CompositeShow) {
				unpack(subshow);
			}
		}

		// 2. A leaf cannot be unpacked
		unpack(MOVIE1);

		// 3. A composite wrapped by a decorator is not a CompositeShow
		unpack(new IntroducedShow(show, "Speaker A", 10));

		// 4. The iterator cannot be used to delete shows from the composite
		Iterator<Show> iterator = ((CompositeShow) show).iterator();
		iterator.next();
		try {
			iterator.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println("remove() is not allowed: the composite is protected");
		}
	}
}