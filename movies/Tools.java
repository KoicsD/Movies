package movies;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Tools
{
	public static String toXMLTag(String tagName, String value)
	{
		return "<" + tagName + ">" + value + "<" + "/" + tagName + ">";
	}
	
	public static boolean tryToWriteXMLFile(List<XMLCompatible> data, String filePath, String tagName)
	{	
		String xMLString = "";
		for(XMLCompatible item: data)
		{
			xMLString += item.toXMLString();
		}
		xMLString = toXMLTag(tagName, xMLString);
		try
		{
			File file = new File(filePath);
			System.out.println("XML Filepath: " + file.getAbsolutePath());
			if (file.createNewFile())
			{
				System.out.println("File was not but has been created.");
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(xMLString);
			fileWriter.flush();
			fileWriter.close();
			return true;
		}
		catch (IOException e)
		{
			System.out.println("An IOEexception was thrown when writing into file:");
			System.out.println("\tType: " + e.getClass().getName());
			System.out.println("\tMessage: " + e.getMessage());
		}
		catch (SecurityException e)
		{
			System.out.println("A SecurityEexception was thrown when writing into file:");
			System.out.println("\tType: " + e.getClass().getName());
			System.out.println("\tMessage: " + e.getMessage());
		}
		return false;
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
	
	public static String[] getProductTitles(List<Product> movies)
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
