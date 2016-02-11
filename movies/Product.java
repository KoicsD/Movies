package movies;


public abstract class Product {
	// instance variables:
	String id;
	String title;
	Person person;
	
	// getters:
	public String getTitle() { return this.title; }
	public Person getPerson() { return this.person; }
	
	// setters:
	// -- trouble with task description: do I have to define them or should I use something else?
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setPerson(Person person)
	{
		this.person = person;
	}
}
