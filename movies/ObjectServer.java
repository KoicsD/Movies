package movies;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ObjectServer {
	// general parameters:
	private static final int TCP = 5000;
	private static final String FILE_PATH = "Data/products.ser";
	
	// server-mode:
	private static enum ServerMode { SAVE, LOAD }
	private static ServerMode mode;
	
	// sockets:
	private static ServerSocket serverObj = null;
	private static Socket connectionToClient = null;
	
	// object streams:
	private static ObjectInputStream objInStreamFromClient = null;
	private static ObjectOutputStream objOutStreamToClient = null;
	private static ObjectInputStream objInStreamFromFile = null;
	private static ObjectOutputStream objOutStreamToFile = null;

	public static void main(String[] args) {
		try {
			startup();
			while (true) {
				receive();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void startup() throws IOException {
		serverObj = new ServerSocket(TCP);
		connectionToClient = serverObj.accept();
		objOutStreamToClient = new ObjectOutputStream(connectionToClient.getOutputStream());
		objInStreamFromClient = new ObjectInputStream(connectionToClient.getInputStream());
	}
	
	private static void shutdown() {
		if (objOutStreamToFile != null)
			try {
				objOutStreamToFile.close();
				objOutStreamToFile = null;
			} catch(IOException e) {
				System.err.println("RESOURCE-LEAKAGE: Unable to close OutputStream to File\n");
				System.err.println("\tReason: " + e.getClass().getName());
				System.err.println("\tMessage: " + e.getMessage());
			}
		if (objInStreamFromFile != null)
			try {
				objInStreamFromFile.close();
				objInStreamFromFile = null;
			} catch(IOException e) {
				System.err.println("RESOURCE-LEAKAGE: Unable to close InputStream from File\n");
				System.err.println("\tReason: " + e.getClass().getName());
				System.err.println("\tMessage: " + e.getMessage());
			}
		if (objOutStreamToClient != null)
			try {
				objOutStreamToClient.close();
				objOutStreamToClient = null;
			} catch(IOException e) {
				System.err.println("RESOURCE-LEAKAGE: Unable to close OutputStream to Client\n");
				System.err.println("\tReason: " + e.getClass().getName());
				System.err.println("\tMessage: " + e.getMessage());
			}
		if (objInStreamFromClient != null)
			try {
				objInStreamFromClient.close();
				objInStreamFromClient = null;
			} catch(IOException e) {
				System.err.println("RESOURCE-LEAKAGE: Unable to close InputStream from Client\n");
				System.err.println("\tReason: " + e.getClass().getName());
				System.err.println("\tMessage: " + e.getMessage());
			}
		if (connectionToClient != null)
			try {
				connectionToClient.close();
				connectionToClient = null;
			} catch(IOException e) {
				System.err.println("RESOURCE-LEAKAGE: Unable to close Socket-connection to Client\n");
				System.err.println("\tReason: " + e.getClass().getName());
				System.err.println("\tMessage: " + e.getMessage());
			}
		if (serverObj != null)
			try {
				serverObj.close();
				serverObj = null;
			} catch(IOException e) {
				System.err.println("RESOURCE-LEAKAGE: Unable to close ServerSocket\n");
				System.err.println("\tReason: " + e.getClass().getName());
				System.err.println("\tMessage: " + e.getMessage());
			}
	}
	
	private static void receive() throws ClassNotFoundException, IOException {
		Object objectReceived = objInStreamFromClient.readObject();
		if (objectReceived instanceof Command) {
			switch ((Command)objectReceived) {
				case GET:
					switchToLoadMode();
					send(load());
					break;
				case PUT:
					switchToSaveMode();
					break;
				case EXIT:
					shutdown();
			}
		} else if (mode != null && mode.equals(ServerMode.SAVE)) {
					save((Product)objectReceived);
		}
	}
	
	private static void send(List<Product> products) throws IOException {
		objOutStreamToClient.writeObject(Command.PUT);
		for (Product product: products) {
			objOutStreamToClient.writeObject(product);
		}
		objOutStreamToClient.writeObject(Command.GET);
	}
	
	private static void switchToLoadMode() throws IOException {
		closeFile();
		objInStreamFromFile = new ObjectInputStream(new FileInputStream(FILE_PATH));
		mode = ServerMode.LOAD;
	}
	
	private static void switchToSaveMode() throws IOException {
		closeFile();
		objOutStreamToFile = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
		mode = ServerMode.SAVE;
	}
	
	private static void closeFile() throws IOException {
		mode = null;
		if (objOutStreamToFile != null) {
			objOutStreamToFile.close();
			objOutStreamToFile = null;
		}
		if (objInStreamFromFile != null) {
			objInStreamFromFile.close();
			objInStreamFromFile = null;
		}
	}
	
	private static void save(Product product) {
		// TODO: here to send Product to .ser file
	}
	
	private static List<Product> load() {
		List<Product> products = new ArrayList<>();
		// TODO: here to recall Products from .ser file to a list
		return products;
	}

}
