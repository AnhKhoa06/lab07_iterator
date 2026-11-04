package ex7;

import java.util.Iterator;

public class Exercise07 {

	private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
	private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
	private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);

	/** Works for any show: no instanceof and no cast needed. */
	private static void unpack(Show pShow) {
		System.out.println("Shows inside: " + pShow.description());
		int count = 0;
		for (Show subshow : pShow) {
			System.out.println("  - " + subshow.description());
			count++;
		}
		if (count == 0) {
			System.out.println("  (none)");
		}
	}

	public static void main(String[] args) {
		Show show = new CompositeShow(CONCERT, new CompositeShow(MOVIE1, MOVIE2));

		// 1. The client treats every show the same way
		unpack(show);
		for (Show subshow : show) {
			unpack(subshow);
		}

		// 2. A decorator is not a composite, so it has no inner shows either
		unpack(new IntroducedShow(show, "Speaker A", 10));

		// 3. The iterator still cannot be used to delete shows
		Iterator<Show> iterator = show.iterator();
		iterator.next();
		try {
			iterator.remove();
		} catch (UnsupportedOperationException e) {
			System.out.println("remove() is not allowed: the composite is protected");
		}
	}
}