package movies;


public class Book extends Product
{
	// instance variable
	protected Person author;
	
	// constructor:
	public Book(String title, Person person)
	{
		super(title, person);
	}
	
	// getter:
	public Person getAuthor() { return this.author; }
	
	// setter:
	public void setAuthor(Person author)
	{
		this.author = author;
	}
	
	// overriding method getInvestment:
	@Override
	public long getInvestment() { return this.author.getSalary(); }
	
	// implementing to-XML converter:
	public String toXMLString()
	{
		String id = Tools.toXMLTag("id", getId());
		String lender = Tools.toXMLTag("lender", this.lender.toXMLString());
		String title = Tools.toXMLTag("title", this.title);
		String author = Tools.toXMLTag("author", this.author.toXMLString());
		return Tools.toXMLTag("Book", id + lender + title + author);
	}
}
