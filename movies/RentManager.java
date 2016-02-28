package movies;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class RentManager {
	private static final String DATA_SENT_XML_PATH = "Data/products_sent.xml";
	private static final String DATA_RECEIVED_XML_PATH = "Data/products_received.xml";
	private static final int TCP = 5000;
	private static final String IP = "127.0.0.1";
	
	private static Socket connectionToServer = null;
	private static ObjectOutputStream objOutStreamToServer = null;
	private static ObjectInputStream objInStreamFromServer = null;
	
	private static void setupConnection() throws ClassNotFoundException, IOException {
		connectionToServer = new Socket(IP, TCP);
		objOutStreamToServer = new ObjectOutputStream(connectionToServer.getOutputStream());
		objInStreamFromServer = new ObjectInputStream(connectionToServer.getInputStream());
		if (!checkIfReceives(Command.GET))
			throw new ProtocollException("Server does not send command GET after connecting");
	}
	
	private static Object safelyReadObject() throws ClassNotFoundException, IOException {
		Object objectRead = objInStreamFromServer.readObject();
		if (objectRead instanceof Command && ((Command)objectRead).equals(Command.EXIT))
			throw new ServerShutdownException("Server sent Command EXIT");
		return objectRead;
	}
	
	private static boolean checkIfReceives(Command command) throws ClassNotFoundException, IOException {
		Object prompt = null;
		prompt = safelyReadObject();
		return prompt instanceof Command && ((Command)prompt).equals(command);
	}
	
	private static void shutdownServer() throws IOException {
		objOutStreamToServer.writeObject(Command.EXIT);
		tryToCloseConnection();
	}
	
	private static void tryToCloseConnection() {
		if (objOutStreamToServer != null)
			try {
				objOutStreamToServer.close();
			} catch (IOException e) {
				System.out.println("Unable to close OutputStream to Server");
			}
		if (objInStreamFromServer != null)
			try {
				objInStreamFromServer.close();
			} catch (IOException e) {
				System.out.println("Unable to close InputStream from Server");
			}
		if (connectionToServer != null)
			try {
				connectionToServer.close();
			} catch (IOException e) {
				System.out.println("Unable to close connection to Server");
			}
	}
	
	private static void sendData(List<Product> products) throws IOException {
		objOutStreamToServer.writeObject(Command.PUT);
		for (Product product: products) {
			objOutStreamToServer.writeObject(product);
		}
	}
	
	private static List<Product> receiveData() throws ClassCastException, ClassNotFoundException, IOException {
		List<Product> products = new ArrayList<>();
		objOutStreamToServer.writeObject(Command.GET);
		if (!checkIfReceives(Command.PUT))
			throw new ProtocollException("Server-Answer does not begin with Command PUT");
		Object objectReceived;
		while(true) {
			objectReceived = safelyReadObject();
			if (objectReceived instanceof Command) {
				Command command = (Command)objectReceived;
				if (command.equals(Command.GET)) break;
				if (command.equals(Command.PUT))
					throw new ProtocollException("Unexpected command PUT");
			}
			products.add((Product)objectReceived);
		}
		return products;
	}

	public static int summarizeIncome(List<Buyable> products)
	{
		int income = 0;
		for (Buyable product: products)
			income += product.getPrice();
		return income;
	}
	
	public static void printInvestments(List<Product> products)
	{
		for (Product product: products)
		{
			System.out.println("Id: " + product.getId());
			System.out.println("\tTitle: " + product.getTitle());
			System.out.println("\tLender: " + product.getLender().getFirstName() + " " + product.getLender().getLastName());
			System.out.println("\tInvestment: " + product.getInvestment());
		}
	}
	
	public static List<Product> generateDemoData()
	{
		List<Product> products = new ArrayList<Product>();

		// movie Matrix
		Movie matrix = new Movie("The Matrix", new Person());
		Person customer = matrix.getLender();
		customer.setFirstName("Adam");
		customer.setLastName("Vegh");
		customer.setGender(Person.Gender.MALE);
		matrix.setGenre(Movie.Genre.SCI_FI);
		List<Actor> cast = new ArrayList<Actor>();
		Actor reeves = new Actor();
		reeves.setFirstName("Keanu");
		reeves.setLastName("Reeves");
		reeves.setGender(Actor.Gender.MALE);
		reeves.setHasOscar(false);
		reeves.setHasGoldenGlobe(false);
		reeves.setSalary(5000);
		cast.add(reeves);
		Actor moss = new Actor();
		moss.setFirstName("Carrie-Anne");
		moss.setLastName("Moss");
		moss.setGender(Actor.Gender.FEMALE);
		moss.setHasOscar(false);
		moss.setHasGoldenGlobe(false);
		moss.setSalary(1200);
		cast.add(moss);
		matrix.setCast(cast);
		matrix.setDuration(136);
		matrix.setRate(8.7);
		matrix.setPrice(10);
		products.add(matrix);
		
		// movie Wolverine
		Movie wolverine = new Movie("Wolverine", new Person());
		customer = wolverine.getLender();
		customer.setFirstName("Anna");
		customer.setLastName("Gerinczy");
		customer.setGender(Person.Gender.FEMALE);
		customer.setSalary(1000);
		wolverine.setGenre(Movie.Genre.SCI_FI);
		cast = new ArrayList<Actor>();
		Actor jackman = new Actor();
		jackman.setFirstName("Hugh");
		jackman.setLastName("Jackman");
		jackman.setGender(Actor.Gender.MALE);
		jackman.setSalary(5500);
		jackman.setHasOscar(false);
		jackman.setHasGoldenGlobe(true);
		cast.add(jackman);
		Actor okamoto = new Actor();
		okamoto.setFirstName("Tao");
		okamoto.setLastName("Okamoto");
		okamoto.setGender(Actor.Gender.FEMALE);
		okamoto.setSalary(4000);
		okamoto.setHasOscar(false);
		okamoto.setHasGoldenGlobe(false);
		cast.add(okamoto);
		Actor fukushima = new Actor();
		fukushima.setFirstName("Rila");
		fukushima.setLastName("Fukushima");
		fukushima.setGender(Actor.Gender.MALE);
		fukushima.setSalary(58679);
		fukushima.setHasOscar(false);
		fukushima.setHasOscar(false);
		wolverine.setCast(cast);
		wolverine.setDuration(126);
		wolverine.setRate(6.7);
		wolverine.setPrice(11);
		products.add(wolverine);
		
		// book Java
		Book bJava = new Book("Java", matrix.getLender());
		Person author = new Person();
		author.setFirstName("Bert");
		author.setLastName("Bates");
		author.setGender(Person.Gender.MALE);
		author.setSalary(6000);
		bJava.setAuthor(author);
		products.add(bJava);
		
		// book Fizika
		Book fizika = new Book("Cultural History of Physics", bJava.getLender());
		author = new Person();
		author.setFirstName("Charles");
		author.setLastName("Simonyi");
		author.setGender(Person.Gender.MALE);
		author.setSalary(4000);
		fizika.setAuthor(author);
		products.add(fizika);
		
		// game Tomb Raider
		Game tombRaider = new Game("Tomb Raider", new Person());
		customer = tombRaider.getLender();
		customer.setFirstName("Lukacs");
		customer.setLastName("Zsori");
		customer.setGender(Person.Gender.MALE);
		List<Person> staff = new ArrayList<Person>();
		Person developer = new Person();
		developer.setFirstName("Chris");
		developer.setLastName("Shrigley");
		developer.setGender(Person.Gender.MALE);
		developer.setSalary(5300);
		staff.add(developer);
		developer = new Person();
		developer.setFirstName("Terry");
		developer.setLastName("Lloyd");
		developer.setGender(Person.Gender.FEMALE);
		developer.setSalary(5300);
		staff.add(developer);
		tombRaider.setStaff(staff);
		tombRaider.setPrice(10);
		products.add(tombRaider);
		
		// game GTA San Andreas
		Game gtaSA = new Game("Grand Theft Auto San Andreas", new Person());
		customer = gtaSA.getLender();
		customer.setFirstName("Marcell");
		customer.setLastName("Koics");
		customer.setGender(Person.Gender.MALE);
		staff = new ArrayList<Person>();
		developer = new Person();
		developer.setFirstName("David");
		developer.setLastName("Jones");
		developer.setGender(Person.Gender.MALE);
		developer.setSalary(5300);
		staff.add(developer);
		developer = new Person();
		developer.setFirstName("Mike");
		developer.setLastName("Dailly");
		developer.setGender(Person.Gender.MALE);
		developer.setSalary(5300);
		staff.add(developer);
		gtaSA.setStaff(staff);
		gtaSA.setPrice(25);
		products.add(gtaSA);
		
		return products;
	}
	
	public static void main(String[] args) {
		List<Product> demoProducts = generateDemoData();
		System.out.println("Products to be sent:");
		System.out.println();
		printInvestments(demoProducts);
		System.out.println();
		Tools.tryToWriteXMLFile(new ArrayList<XMLCompatible>(demoProducts), DATA_SENT_XML_PATH, "products");
		System.out.println();
		try {
			System.out.println("Connecting to server...");
			setupConnection();
			System.out.println("Connection established");
			System.out.println("Sending data...");
			sendData(demoProducts);
			System.out.println("Success");
			System.out.println("Receiving data...");
			List<Product> receivedData = receiveData();
			System.out.println("Success");
			System.out.println();
			System.out.println("Data received:");
			System.out.println();
			printInvestments(receivedData);
			System.out.println();
			Tools.tryToWriteXMLFile(new ArrayList<XMLCompatible>(demoProducts), DATA_RECEIVED_XML_PATH, "products");
			System.out.println();
			System.out.println("Stopping server...");
			shutdownServer();
			System.out.println("Success");
			System.out.println("Bye.");
			System.exit(0);  // no need of finally block
		} catch (ClassCastException e) {
			System.out.println("An Object cannot be casted to Product");
			System.out.println("\tMessage: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Class of an Object cannot be found");
			System.out.println("\tMessage: " + e.getMessage());
		} catch (ServerShutdownException e) {
			System.out.println("Server decided to Shutdown");
			tryToCloseConnection();
			System.out.println("Bye.");
			System.exit(0);  // no need to try to shutdown server
		}
		catch (IOException e) {
			System.out.println("An IOException has occoured");
			System.out.println("Type: " + e.getClass().getName());
			System.out.println("\tReason: "+ e.getMessage());
		} finally {
			try {
				shutdownServer();
			} catch (NullPointerException | IOException e) {
				System.out.println("Unable to invoke Server-Shutdown");
				tryToCloseConnection();
				System.out.println("Bye.");
			}
		}
	}
}
