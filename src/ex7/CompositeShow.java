package ex7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

/**
 * A show that is a combination of between two and five other shows.
 * Iteration is part of the Show interface, so every show can be iterated.
 */
public class CompositeShow implements Show {

	private final List<Show> aShows = new ArrayList<>();

	public CompositeShow(Show... pShows) {
		if (pShows.length < 2 || pShows.length > 5) {
			throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
		}
		aShows.addAll(Arrays.asList(pShows));
	}

	@Override
	public Iterator<Show> iterator() {
		return Collections.unmodifiableList(aShows).iterator();
	}

	@Override
	public String description() {
		StringJoiner description = new StringJoiner("; ", "[", "]");
		for (Show show : aShows) {
			description.add(show.description());
		}
		return description.toString();
	}

	@Override
	public int runningTime() {
		int time = 0;
		for (Show show : aShows) {
			time += show.runningTime();
		}
		return time;
	}

	@Override
	public Show copy() {
		Show[] copies = new Show[aShows.size()];
		for (int i = 0; i < copies.length; i++) {
			copies[i] = aShows.get(i).copy();
		}
		return new CompositeShow(copies);
	}
}