package movies;


public abstract class Product {
	// instance variables:
	private String id;
	protected String title;
	protected Person person;
	
	// constructor:
	public Product(String title, Person person)
	{
		this.id = IdGenerator.generate(this);
		this.title = title;
		this.person = person;
	}
	
	// getters:
	public String getId() { return this.id; }
	public String getTitle() { return this.title; }
	public Person getPerson() { return this.person; }
	
	// setters:
	// -- trouble with task description: do I have to define them or should I use something else?
	/* -- I use something else: constructor
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setPerson(Person person)
	{
		this.person = person;
	}
	*/
	
	// abstract method getInvestment():
	public abstract long getInvestment();
}
