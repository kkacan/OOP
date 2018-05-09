
public class AgeInputException extends Exception {


	/**
	 *
	 */
	private static final long serialVersionUID = -774046946342444302L;
	private int lower;
	private int upper;
	private int val;

	public AgeInputException(int low, int upp, int input, String s) {

		super(s);

		lower = low;
		upper = upp;
		val = input;

	}

	public int getLower() {
		return lower;
	}

	public int getUpper() {
		return upper;
	}

	public int getVal() {
		return val;
	}

}