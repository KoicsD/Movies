package movies;


public class Actor extends Person {
	// instance variables:
	protected boolean hasOscar;
	protected boolean hasGoldenGlobe;
	
	// getters:
	public boolean isHasOscar() { return this.hasOscar; }
	public boolean isHasGoldenGlobe() { return this.hasGoldenGlobe; }
	
	// setters:
	public void setHasOscar(boolean hasOscar)
	{
		this.hasOscar = hasOscar;
	}
	
	public void setHasGoldenGlobe(boolean hasGoldenGlobe)
	{
		this.hasGoldenGlobe = hasGoldenGlobe;
	}
	
	// to-XML converter:
	public String toXMLString()
	{
		String firstName = Tools.toXMLTag("firstName", this.firstName);
		String lastName = Tools.toXMLTag("lastName", this.lastName);
		String gender = Tools.toXMLTag("gender", this.gender.toString());
		String hasOscar = Tools.toXMLTag("hasOscar", Boolean.toString(this.hasOscar));
		String hasGoldenGlobe = Tools.toXMLTag("hasGoldenGlobe", Boolean.toString(this.hasGoldenGlobe));
		return Tools.toXMLTag("Actor", firstName + lastName + gender + hasOscar + hasGoldenGlobe);
	}
}
