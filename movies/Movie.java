package movies;
import java.util.List;
import java.util.ArrayList;


public class Movie extends Product
{
	// possible genres as enumeration:
	public static enum Genre
	{
		ACTION,
		THRILLER,
		HORROR,
		SCI_FI,
		ROMANTIC,
		COMEDY,
		DRAMA
	}
	
	// instance variables:
	protected Genre genre;
	protected long duration;
	protected double rate;
	protected ArrayList<Actor> cast;
	
	// getter functions:
	public Genre getGenre() { return this.genre; }
	public long getDuration() { return this.duration; }
	public double getRate() { return this.rate; }
	public ArrayList<Actor> getCast() { return this.cast; }
	
	// setter functions:
	public void setGenre(Genre genre)
	{
		this.genre = genre;
	}
	
	public void setDuration(long duration)
	{
		this.duration = duration;
	}
	
	public void setRate(double rate)
	{
		this.rate = rate;
	}
	
	public void setCast(List<Actor> cast)
	{
		this.cast = new ArrayList<Actor>(cast);  // this makes a (shallow) copy of the list (and also force a type-cast)
	}
	
	// to-XML converter:
	public String toXML()
	{
		String title = Tools.toXML("title", this.title);
		String genre = Tools.toXML("genre", this.genre.toString());
		String duration = Tools.toXML("duration", Long.toString(this.duration));
		String rate = Tools.toXML("rate", Double.toString(this.rate));
		String cast = Tools.toXML("cast", personsToXML(this.cast));
		return Tools.toXML("Movie", title + genre + duration + rate + cast);
	}
	
	private static String personsToXML(List<Actor> actors)
	{
		String retStr = "";
		for (Actor actor: actors)
		{
			retStr += actor.toXML();
		}
		return retStr;
	}
}
