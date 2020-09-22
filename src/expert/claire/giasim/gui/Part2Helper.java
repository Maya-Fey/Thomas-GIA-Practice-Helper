package expert.claire.giasim.gui;

import java.util.Random;

import javax.swing.JTextArea;

import expert.claire.giasim.logic.RandHelper;

public class Part2Helper {

	private static final Random rand = new Random();
	
	public static int populateTA(JTextArea area)
	{
		char[] chars = new char[4];
		boolean[] bools = new boolean[4];
		int correct = 0;
		for(int i = 0; i < 4; i++) {
			chars[i] = randChar();
			bools[i] = RandHelper.bool();
			if(bools[i]) correct++;
			area.append(chars[i] + "  ");
		}
		area.append("\n\n");
		for(int i = 0; i < 4; i++) {
			area.append((bools[i] ? toLower(chars[i]) : getCharThatIsnt(chars[i])) + "  ");
		}
		return correct;
	}
	
	public static char getCharThatIsnt(char c) 
	{
		char n;
		do {
			n = randChar();
		} while(n == c);
		return toLower(n);
	}
	
	public static char toLower(char c) 
	{
		return (char) (c + ('a' - 'A'));
	}
	
	public static char randChar()
	{
		return (char) ('A' + rand.nextInt(26));
	}

}
