package ex7;

import java.util.Collections;
import java.util.Iterator;

/** Decorator: a show introduced by a speaker giving a fixed-time speech. */
public class IntroducedShow implements Show {

	private final Show aShow;
	private final String aSpeaker;
	private final int aSpeechTime;

	public IntroducedShow(Show pShow, String pSpeaker, int pSpeechTime) {
		aShow = pShow;
		aSpeaker = pSpeaker;
		aSpeechTime = pSpeechTime;
	}

	@Override
	public String description() {
		return String.format("%s introduces %s", aSpeaker, aShow.description());
	}

	@Override
	public int runningTime() {
		return aSpeechTime + aShow.runningTime();
	}

	@Override
	public Show copy() {
		return new IntroducedShow(aShow.copy(), aSpeaker, aSpeechTime);
	}

	@Override
	public Iterator<Show> iterator() {
		return Collections.emptyIterator();
	}
}