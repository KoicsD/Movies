package movies;

import java.io.Serializable;

public abstract class Product implements XMLCompatible, Serializable {
	// instance variables:
	private String id;
	protected String title;
	protected Person lender;
	
	// constructor:
	public Product(String title, Person lender)
	{
		this.id = IdGenerator.generate(this);
		this.title = title;
		this.lender = lender;
	}
	
	// getters:
	public String getId() { return this.id; }
	public String getTitle() { return this.title; }
	public Person getLender() { return this.lender; }
	
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
