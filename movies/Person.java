package movies;


public class Person
{
	// genders as enumeration:
	public static enum Gender {MALE, FEMALE}
	
	// instance variables:
	protected String firstName;
	protected String lastName;
	protected Gender gender;
	protected int salary;
	
	// getter functions:
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public Gender getGender() { return this.gender; }
	public int getSalary() { return this.salary; }
	
	// setter functions:
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}
	
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	
	// to-XML converter:
		public String toXMLString()
		{
			String firstName = Tools.toXMLTag("firstName", this.firstName);
			String lastName = Tools.toXMLTag("lastName", this.lastName);
			String gender = Tools.toXMLTag("gender", this.gender.toString());
			String salary = Tools.toXMLTag("salary", String.valueOf(this.salary));
			return Tools.toXMLTag("Person", firstName + lastName + gender + salary);
		}
}
