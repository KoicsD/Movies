package movies;

import java.io.Serializable;

public interface Buyable extends XMLCompatible, Serializable {
	public String getId();
	public String getTitle();
	public int getPrice();
}
