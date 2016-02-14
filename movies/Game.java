package movies;
import java.util.List;
import java.util.ArrayList;


public class Game extends Product implements Buyable
{
	// instance variables:
	protected boolean preOrdered;
	ArrayList<Person> staff;
	int price;
	
	// constructor:
	public Game(String title, Person person)
	{
		super(title, person);
	}
	
	// getters:
	public boolean isPreordered() { return this.preOrdered; }
	public List<Person> getStaff() { return this.staff; }
	
	// setters:
	public void setPreordered(boolean preOrdered)
	{
		this.preOrdered = preOrdered;
	}
	
	public void setStaff(List<Person> staff)
	{
		this.staff = new ArrayList<Person>(staff);  // I like copying
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}
	
	// overriding abstract methods:
	@Override
	public int getPrice()
	{
		int price = 0;
		if (this.preOrdered)
			return (int)(price * 0.8);
		else
			return price;
	}
	
	@Override
	public long getInvestment()
	{
		int investment = 0;
		for (Person person: staff)
			investment += person.getSalary();
		return investment;
	}
	
	// implementing to-XML converter:
	@Override
	public String toXMLString()
	{
		String id = Tools.toXMLTag("id", getId());
		String lender = Tools.toXMLTag("lender", this.lender.toXMLString());
		String title = Tools.toXMLTag("title", this.title);
		String preOrdered = Tools.toXMLTag("preOrdered", String.valueOf(this.preOrdered));
		String staff = Tools.toXMLTag("staff", personsToXML(this.staff));
		return Tools.toXMLTag("Game", id + lender + title + preOrdered + staff);
	}
	
	private static String personsToXML(List<Person> staff)
	{
		String retStr = "";
		for (Person developer: staff)
		{
			retStr += developer.toXMLString();
		}
		return retStr;
	}
}
