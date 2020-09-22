package expert.claire.giasim.logic;

public class Name {
	
	private static final String[] names = {
		"Brice", "Darrell", "Todd", "Lin", "Natalia", "Sherice", "Priscila", "Rich", "Leonila", "Eugena",
		"Joe", "Viki", "Yuki", "Romelia", "Tynisha", "Youlanda", "Evon", "Laure", "Elma", "Murray", "Lily", 
		"Mana", "Kiley", "Jina", "Aaron", "Detra", "Antonette", "Isabelle", "Reva", "Oscar", "Livia", "Warner", 
		"Chase", "Deandra", "Leone", "Lora", "Pam", "Annabelle", "Joella", "Jodie", "Korey", "Betsey", "Ellen", 
		"Babette", "Sau", "Tifany", "Sidney", "Lizbeth", "Temeka", "Kristal"
	};
	
	public static final String newName()
	{
		return RandHelper.selectFrom(names);
	}

}
