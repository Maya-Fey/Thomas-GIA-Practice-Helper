package expert.claire.giasim.logic;

public enum Adjective {
	
	STRENGTH("strong", "weak"),
	HEIGHT("tall", "short"),
	HEIGHT2("high", "low"),
	WEIGHT(new String[] { "heavier than", "weighs more than", "is not as light as" }, new String [] { "lighter than", "weighs less than", "is not as heavy as" }, new String[] { "is heavier", "weighs more" }, new String[] { "is lighter", "weighs less" }),
	EMMISIVITY("bright", "dull"),
	EMOTE("happy", "sad");
	
	private final String[] compHigher;
	private final String[] compLower;
	private final String[] absHigher;
	private final String[] absLower;
	
	/**
	 * @param compHigher
	 * @param compLower
	 * @param absHigher
	 * @param absLower
	 */
	private Adjective(String[] compHigher, String[] compLower, String[] absHigher, String[] absLower) {
		this.compHigher = compHigher;
		this.compLower = compLower;
		this.absHigher = absHigher;
		this.absLower = absLower;
	}

	/**
	 * @param higher
	 * @param lower
	 */
	private Adjective(String higher, String lower) {
		this.compHigher = new String[] { "is " + higher + "er than", "is not as " + lower + " as" };
		this.compLower = new String[] { "is " + lower + "er than", "is not as " + higher + " as" };
		this.absHigher = new String[] { "is " + higher + "er" };
		this.absLower = new String[] { "is " + lower + "er" };
	}
	
	private String[] comp(boolean highOrLow)
	{
		return highOrLow ? this.compHigher : this.compLower;
	}
	
	private String[] abs(boolean highOrLow)
	{
		return highOrLow ? this.absHigher : this.absLower;
	}
	
	public String[] inSentence(String nameCorrect, String nameIncorrect)
	{
		boolean comp = RandHelper.bool(); //the high/low of the given comparison
		boolean abs = RandHelper.bool(); //The high/low of the question
		//If the comp is equal to abs, correct goes first. invert otherwise
		String compFirst = (comp == abs) ? nameCorrect : nameIncorrect;
		String compSecond = (comp != abs) ? nameCorrect : nameIncorrect;
		return new String[] {
			compFirst + " " + RandHelper.selectFrom(this.comp(comp)) + " " + compSecond,
			"Who " + RandHelper.selectFrom(this.abs(abs))
		};
	}
	
	public static final Adjective newAdjective()
	{
		return RandHelper.selectFrom(values());
	}

}
