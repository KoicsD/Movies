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
	public String toXML()
	{
		String firstName = Tools.toXML("firstName", this.firstName);
		String lastName = Tools.toXML("lastName", this.lastName);
		String gender = Tools.toXML("gender", this.gender.toString());
		String hasOscar = Tools.toXML("hasOscar", Boolean.toString(this.hasOscar));
		String hasGoldenGlobe = Tools.toXML("hasGoldenGlobe", Boolean.toString(this.hasGoldenGlobe));
		return Tools.toXML("Actor", firstName + lastName + gender + hasOscar + hasGoldenGlobe);
	}
}
