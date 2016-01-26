import java.util.List;


enum Genre
{
	ACTION,
	THRILLER,
	HORROR,
	SCI_FI,
	ROMANTIC,
	COMEDY,
	DRAMA
}


public class Movie
{
	String title;
	Genre genre;
	long duration;
	double rate;
	List<Person> cast;
}
