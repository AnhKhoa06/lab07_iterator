package ex6;

/** A show that consists of a concert. */
public class Concert implements Show {

	private final String aTitle;
	private final String aPerformer;
	private final int aRunningTime;

	public Concert(String pTitle, String pPerformer, int pTime) {
		aTitle = pTitle;
		aPerformer = pPerformer;
		aRunningTime = pTime;
	}

	@Override
	public String description() {
		return String.format("%s by %s", aTitle, aPerformer);
	}

	@Override
	public int runningTime() {
		return aRunningTime;
	}

	@Override
	public Show copy() {
		return new Concert(aTitle, aPerformer, aRunningTime);
	}
}