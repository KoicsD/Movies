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

}