package movies;
import java.util.HashMap;
import java.util.List;


public class Tools
{
	public static String toXMLTag(String tagName, String value)
	{
		return "<" + tagName + ">" + value + "<" + "/" + tagName + ">";
	}
	
	public static HashMap<Actor, Integer> countMoviesPerActor(List<Movie> movies)
	{
		HashMap<Actor, Integer> moviesPerActor = new HashMap<Actor, Integer>();
		for(Movie movie: movies)
		{
			for(Actor actor: movie.getCast())
			{
				if(moviesPerActor.containsKey(actor))
				{
					moviesPerActor.put(actor, moviesPerActor.get(actor) + 1);
				}
				else
				{
					moviesPerActor.put(actor, 0);
				}
			}
		}
		return moviesPerActor;
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
