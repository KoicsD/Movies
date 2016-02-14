package movies;

import java.util.List;
import java.util.ArrayList;


public class MovieManager
{
	private static final String XML_FILE_PATH = "Data/movies.xml"; 
	
	public static void printTitles(String[] titles)
	{
		System.out.println("The titles of movies:");
		for (String title: titles)
			System.out.println(title);
	}
	
	public static List<Movie> generateDemoData()
	{
		// collecting mentors:
		Person[] mentors = new Person[3];
		
		mentors[0] = new Person();
		Person ngAtesz = mentors[0];
		ngAtesz.setFirstName("Attila");
		ngAtesz.setLastName("Molnár");
		ngAtesz.setGender(Person.Gender.MALE);
		ngAtesz.setSalary(1500); // USD
		
		mentors[1] = new Person();
		Person ngPakko = mentors[1];
		ngPakko.setFirstName("Pál");
		ngPakko.setLastName("Monoczky");
		ngPakko.setGender(Person.Gender.MALE);
		ngPakko.setSalary(1500); // USD
		
		mentors[2] = new Person();
		Person szody = mentors[2];
		szody.setFirstName("Sándor");
		szody.setLastName("Szodoray");
		szody.setGender(Person.Gender.MALE);
		szody.setSalary(1500); // USD
		
		// collecting actors:
		Actor[] mentorsFavouriteActors = new Actor[5];
		
		mentorsFavouriteActors[0] = new Actor();
		Actor diCaprio = mentorsFavouriteActors[0];
		diCaprio.setFirstName("Leonardo");
		diCaprio.setLastName("Di Caprio");
		diCaprio.setGender(Actor.Gender.MALE);
		diCaprio.setSalary(5000);
		diCaprio.setHasOscar(false);
		diCaprio.setHasGoldenGlobe(true);
		
		mentorsFavouriteActors[1] = new Actor();
		Actor winslet = mentorsFavouriteActors[1];
		winslet.setFirstName("Kate");
		winslet.setLastName("Winslet");
		winslet.setGender(Actor.Gender.FEMALE);
		winslet.setSalary(4000);
		winslet.setHasOscar(true);
		winslet.setHasGoldenGlobe(true);
		
		mentorsFavouriteActors[2] = new Actor();
		Actor reeves = mentorsFavouriteActors[2];
		reeves.setFirstName("Keanu");
		reeves.setLastName("Reeves");
		reeves.setGender(Actor.Gender.MALE);
		reeves.setSalary(5000);
		reeves.setHasOscar(false);
		reeves.setHasGoldenGlobe(false);
		
		mentorsFavouriteActors[3] = new Actor();
		Actor moss = mentorsFavouriteActors[3];
		moss.setFirstName("Carrie-Anne");
		moss.setLastName("Moss");
		moss.setGender(Actor.Gender.FEMALE);
		moss.setSalary(800);
		moss.setHasOscar(false);
		moss.setHasGoldenGlobe(false);
		
		mentorsFavouriteActors[4] = new Actor();
		Actor cotillard = mentorsFavouriteActors[4];
		cotillard.setFirstName("Marion");
		cotillard.setLastName("Cotillard");
		cotillard.setGender(Actor.Gender.FEMALE);
		cotillard.setSalary(6200);
		cotillard.setHasOscar(true);
		cotillard.setHasGoldenGlobe(true);
		
		// collecting movies:
		ArrayList<Movie> mentorsFavouriteMovies = new ArrayList<Movie>(3);
		List<Actor> cast = new ArrayList<Actor>();
		
		mentorsFavouriteMovies.add(new Movie("Titanic", ngPakko));
		Movie titanic = mentorsFavouriteMovies.get(0);
		titanic.setGenre(Movie.Genre.ROMANTIC);
		titanic.setDuration(200);
		titanic.setRate(4.8);
		cast.add(diCaprio);
		cast.add(winslet);
		titanic.setCast(cast);
		
		cast.clear(); // I can only do this because Movie.setCast invokes operator 'new'
		
		mentorsFavouriteMovies.add(new Movie("The Matrix", ngAtesz));
		Movie theMatrix = mentorsFavouriteMovies.get(1);
		theMatrix.setGenre(Movie.Genre.SCI_FI);
		theMatrix.setDuration(140);
		theMatrix.setRate(5.0);
		cast.add(reeves);
		cast.add(moss);
		theMatrix.setCast(cast);
		
		cast.clear();
		
		mentorsFavouriteMovies.add(new Movie("Inception", szody));
		Movie inception = mentorsFavouriteMovies.get(2);
		inception.setGenre(Movie.Genre.SCI_FI);
		inception.setDuration(160);
		inception.setRate(5.0);
		cast.add(cotillard);
		cast.add(diCaprio);
		inception.setCast(cast);
		
		return mentorsFavouriteMovies;
	}
	
	public static void main(String[] args)
	{
		List<Movie> demoMovies = generateDemoData();
		String[] titles = Tools.getMovieTitles(demoMovies);
		printTitles(titles);
		Tools.tryToWriteXMLFile(new ArrayList<XMLCompatible>(demoMovies), XML_FILE_PATH, "movies");
	}
}
