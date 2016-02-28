package movies;

import java.io.IOException;

public class ServerShutdownException extends IOException {
	public ServerShutdownException(){}
	public ServerShutdownException(String message) { super(message); }
	public ServerShutdownException(String message, Throwable cause) { super(message, cause); }
}
