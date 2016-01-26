import java.util.HashMap;
import java.util.List;


public class Tools
{
	public static int theAnswer = 42;
	
	public static String toXML(String tagName, String value)
	{
		return "<" + tagName + ">" + value + "<" + "/" + tagName + ">";
	}
	
	public static HashMap<Person, Integer> countMoviesPerPerson(List<Movie> movies)
	{
		HashMap<Person, Integer> moviesPerPerson = new HashMap<Person, Integer>();
		for(Movie movie: movies)
		{
			for(Person person: movie.getCast())
			{
				if(moviesPerPerson.containsKey(person))
				{
					moviesPerPerson.put(person, moviesPerPerson.get(person) + 1);
				}
				else
				{
					moviesPerPerson.put(person, 0);
				}
			}
		}
		return moviesPerPerson;
	}
	
	public static String[] getMovieTitles(List<Movie> movies)
	{
		int size = movies.size();
		String[] titles = new String[size];
		for(int i = 0; i < size; ++i)
		{
			titles[i] = movies.get(i).getTitle();
		}
		return titles;
	}
}
