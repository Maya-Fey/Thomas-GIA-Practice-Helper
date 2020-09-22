package expert.claire.giasim.logic;

import java.util.Random;

public class RandHelper {
	
	private static final Random random = new Random();
	
	public static final <T> T selectFrom(T[] t)
	{
		return t[random.nextInt(t.length)];
	}
	
	public static final boolean bool()
	{
		return random.nextBoolean();
	}

}
