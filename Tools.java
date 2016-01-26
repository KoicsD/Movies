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
		return new HashMap<Person, Integer>();
	}
	
	public static String[] getMovieTitles(List<Movie> movies)
	{
		return new String[0];
	}
}
