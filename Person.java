enum Gender {MALE, FEMALE}


public class Person
{
	// instance variables:
	String firstName;
	String lastName;
	Gender gender;
	boolean hasOscar;
	boolean hasGoldenGlobe;
	
	// getter functions:
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public Gender getGender() { return this.gender; }
	public boolean isHasOscar() { return this.hasOscar; }
	public boolean isHasGoldenGlobe() { return this.hasGoldenGlobe; }
	
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
	
	public void setHasOscar(boolean hasOscar)
	{
		this.hasOscar = hasOscar;
	}
	
	public void setHasGoldenGlobe(boolean hasGoldenGlobe)
	{
		this.hasGoldenGlobe = hasGoldenGlobe;
	}
	
	// to-XML converter:
	public String toXML()
	{
		String firstName = Tools.toXML("firstName", this.firstName);
		String lastName = Tools.toXML("lastName", this.lastName);
		String gender = Tools.toXML("gender", this.gender.toString());
		String hasOscar = Tools.toXML("hasOscar", Boolean.toString(this.hasOscar));
		String hasGoldenGlobe = Tools.toXML("hasGoldenGlobe", Boolean.toString(this.hasGoldenGlobe));
		return Tools.toXML("Person", firstName + lastName + gender + hasOscar + hasGoldenGlobe);
	}
}
