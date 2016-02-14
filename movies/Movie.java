package movies;
import java.util.List;
import java.util.ArrayList;


public class Movie extends Product implements Buyable
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
	protected int price;
	
	// constructor:
	public Movie(String title, Person person)
	{
		super(title, person);
	}
	
	// getter functions:
	public Genre getGenre() { return this.genre; }
	public long getDuration() { return this.duration; }
	public double getRate() { return this.rate; }
	public ArrayList<Actor> getCast() { return this.cast; }
	public int getPrice() { return this.price; }
	
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
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	// implementation of abstract method getInvestment:
	@Override
	public long getInvestment()
	{
		long investment = 0;
		for (Actor actor: cast)
		{
			investment += actor.getSalary();
		}
		return investment;
	}
	
	// to-XML converter:
	@Override
	public String toXMLString()
	{
		String id = Tools.toXMLTag("id", getId());
		String lender = Tools.toXMLTag("lender", this.lender.toXMLString());
		String title = Tools.toXMLTag("title", this.title);
		String genre = Tools.toXMLTag("genre", this.genre.toString());
		String duration = Tools.toXMLTag("duration", Long.toString(this.duration));
		String rate = Tools.toXMLTag("rate", Double.toString(this.rate));
		String cast = Tools.toXMLTag("cast", personsToXML(this.cast));
		return Tools.toXMLTag("Movie", id + lender + title + genre + duration + rate + cast);
	}
	
	private static String personsToXML(List<Actor> actors)
	{
		String retStr = "";
		for (Actor actor: actors)
		{
			retStr += actor.toXMLString();
		}
		return retStr;
	}
}
