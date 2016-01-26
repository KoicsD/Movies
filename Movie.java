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
	// instance variables:
	String title;
	Genre genre;
	long duration;
	double rate;
	List<Person> cast;
	
	// getter functions:
	public String getTitle() { return this.title; }
	public Genre getGenre() { return this.genre; }
	public long getDuration() { return this.duration; }
	public double getRate() { return this.rate; }
	public List<Person> getCast() { return this.cast; }
	
	// setter functions:
	public void setTitle(String title)
	{
		this.title = title;
	}
	
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
	
	public void setCast(List<Person> cast)
	{
		this.cast = cast;
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
	
	private static String personsToXML(List<Person> persons)
	{
		String retStr = "";
		for(Person person: persons)
		{
			retStr += person.toXML();
		}
		return retStr;
	}
}
