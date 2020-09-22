package expert.claire.giasim;

import expert.claire.giasim.logic.Adjective;
import expert.claire.giasim.logic.Name;

public class Test {

	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			String[] strs = Adjective.newAdjective().inSentence(Name.newName(), Name.newName());
			System.out.println(strs[0]);
			System.out.println(strs[1]);
			System.out.println();
		}
	}

}
