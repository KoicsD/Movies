package movies;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MovieManager
{
	private static final String XML_FILE_PATH = "Data/movies.xml"; 
	
	public static void main(String[] args)
	{
		// collecting actors:
		Actor[] mentorsFavouriteActors = new Actor[5];
		
		mentorsFavouriteActors[0] = new Actor();
		Actor diCaprio = mentorsFavouriteActors[0];
		diCaprio.setFirstName("Leonardo");
		diCaprio.setLastName("Di Caprio");
		diCaprio.setGender(Actor.Gender.MALE);
		diCaprio.setHasOscar(false);
		diCaprio.setHasGoldenGlobe(true);
		
		mentorsFavouriteActors[1] = new Actor();
		Actor winslet = mentorsFavouriteActors[1];
		winslet.setFirstName("Kate");
		winslet.setLastName("Winslet");
		winslet.setGender(Actor.Gender.FEMALE);
		winslet.setHasOscar(true);
		winslet.setHasGoldenGlobe(true);
		
		mentorsFavouriteActors[2] = new Actor();
		Actor reeves = mentorsFavouriteActors[2];
		reeves.setFirstName("Keanu");
		reeves.setLastName("Reeves");
		reeves.setGender(Actor.Gender.MALE);
		reeves.setHasOscar(false);
		reeves.setHasGoldenGlobe(false);
		
		mentorsFavouriteActors[3] = new Actor();
		Actor moss = mentorsFavouriteActors[3];
		moss.setFirstName("Carrie-Anne");
		moss.setLastName("Moss");
		moss.setGender(Actor.Gender.FEMALE);
		moss.setHasOscar(false);
		moss.setHasGoldenGlobe(false);
		
		mentorsFavouriteActors[4] = new Actor();
		Actor cotillard = mentorsFavouriteActors[4];
		cotillard.setFirstName("Marion");
		cotillard.setLastName("Cotillard");
		cotillard.setGender(Actor.Gender.FEMALE);
		cotillard.setHasOscar(true);
		cotillard.setHasGoldenGlobe(true);
		
		// collecting movies:
		ArrayList<Movie> mentorsFavouriteMovies = new ArrayList<Movie>(3);
		List<Actor> cast = new ArrayList<Actor>();
		
		mentorsFavouriteMovies.add(new Movie());
		Movie titanic = mentorsFavouriteMovies.get(0);
		titanic.setTitle("Titanic");
		titanic.setGenre(Movie.Genre.ROMANTIC);
		titanic.setDuration(200);
		titanic.setRate(4.8);
		cast.add(diCaprio);
		cast.add(winslet);
		titanic.setCast(cast);
		
		cast.clear();
		
		mentorsFavouriteMovies.add(new Movie());
		Movie theMatrix = mentorsFavouriteMovies.get(1);
		theMatrix.setTitle("The Matrix");
		theMatrix.setGenre(Movie.Genre.SCI_FI);
		theMatrix.setDuration(140);
		theMatrix.setRate(5.0);
		cast.add(reeves);
		cast.add(moss);
		theMatrix.setCast(cast);
		
		cast.clear();
		
		mentorsFavouriteMovies.add(new Movie());
		Movie inception = mentorsFavouriteMovies.get(2);
		inception.setTitle("Inception");
		inception.setGenre(Movie.Genre.SCI_FI);
		inception.setDuration(160);
		inception.setRate(5.0);
		cast.add(cotillard);
		cast.add(diCaprio);
		inception.setCast(cast);
		
		// getting and printing titles of movies:
		String[] titles = Tools.getMovieTitles(mentorsFavouriteMovies);
		System.out.println("The titles of movies:");
		for(String title: titles)
		{
			System.out.println(title);
		}
		
		// getting XML-notation string of the movies and writing them into file:
		String xMLString = "";
		for(Movie movie: mentorsFavouriteMovies)
		{
			xMLString += movie.toXML();
		}
		xMLString = Tools.toXML("movies", xMLString);
		File file = new File(XML_FILE_PATH);
		try
		{
			if (file.createNewFile())
			{
				System.out.println("File was not but has been created.");
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(xMLString);
			fileWriter.flush();
			fileWriter.close();
		}
		catch (IOException e)
		{
			System.out.println("An IOEexception was thrown when creating new file:");
			System.out.println(e.getMessage());
		}
		catch (SecurityException e)
		{
			System.out.println("A SecurityEexception was thrown when creating new file:");
			System.out.println(e.getMessage());
		}
	}
}
