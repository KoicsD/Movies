package movies;


class IdGenerator {
	private static int numberOfBooks = 0;
	private static int numberOfMovies = 0;
	private static int numberOfGames = 0;
	
	static String generate(Product product)
	{
		if (product instanceof Book)
			return "BOO" + String.valueOf(++numberOfBooks);
		if (product instanceof Movie)
			return "MOV" + String.valueOf(++numberOfMovies);
		if (product instanceof Game)
			return "GAM" + String.valueOf(++numberOfGames);
		return "";
	}
}
