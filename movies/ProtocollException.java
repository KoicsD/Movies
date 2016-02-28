package movies;

import java.io.IOException;

public class ProtocollException extends IOException {
	public ProtocollException(){}
	public ProtocollException(String message) { super(message); }
	public ProtocollException(String message, Throwable cause) { super(message, cause); }
}
