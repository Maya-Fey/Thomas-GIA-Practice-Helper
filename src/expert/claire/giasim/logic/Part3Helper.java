package expert.claire.giasim.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Part3Helper {

	private final Random random = new Random();
	private final List<Integer> list = new ArrayList<>(3);
	
	public int generateProblem(int[] toWrite) 
	{
		this.list.clear();
		int middle = 5 + this.random.nextInt(25);
		int closerdiff = this.random.nextInt(middle - 2);
		int farther = closerdiff + 1 + this.random.nextInt(2);
		boolean down = RandHelper.bool();
		int lowerInt = down ? middle - farther : middle - closerdiff;
		int upperInt = !down ? middle + farther : middle + closerdiff;
		this.list.add(middle);
		this.list.add(lowerInt);
		this.list.add(upperInt);
		Collections.shuffle(this.list);
		for(int i = 0; i < 3; i++)
			toWrite[i] = this.list.get(i);
		return down ? lowerInt : upperInt;
	}
}
