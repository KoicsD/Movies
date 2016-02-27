package movies;

import java.io.EOFException;
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
	private static ServerSocket server = null;
	private static Socket socket = null;
	
	// object streams:
	private static ObjectInputStream objInpStreamFromSocket = null;
	private static ObjectOutputStream objOutStremToSocket = null;
	private static ObjectInputStream objInpStreamFromFile = null;
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
	
	private static void startup() {
		// TODO: here to start server and invoke accept()
	}
	
	private static void shutdown() {
		// TODO: here to close all sockets and streams and invoke System.exit()
	}
	
	private static void receive() throws ClassNotFoundException, IOException {
		try { // EOFException if nothing has been sent yet
			Object objectReceived = objInpStreamFromSocket.readObject();
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
		} catch (EOFException e) {
			// nothing has been sent yet, nothing to do
		}
	}
	
	private static void send(List<Product> products) {
		// TODO: here to send products from a list
	}
	
	private static void switchToLoadMode() {
		// TODO: here to close objInpStreamFromFile and create objOutStreamToFile
	}
	
	private static void switchToSaveMode() {
		// TODO: here to close objOutStreamToFile and create objInpStreamFromFile
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
