package movies;


public class Person
{
	// genders as enumeration:
	public static enum Gender {MALE, FEMALE}
	
	// instance variables:
	String firstName;
	String lastName;
	Gender gender;
	int salary;
	
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
}
