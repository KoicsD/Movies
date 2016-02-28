package movies;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class RentManager {
	private static final String XML_FILE_PATH = "Data/products.xml";
	private static final int TCP = 5000;
	private static final String IP = "127.0.0.1";
	
	private static Socket connectionToServer = null;
	private static ObjectOutputStream objOutStreamToServer = null;
	private static ObjectInputStream objInStreamFromServer = null;
	
	private static void setupConnection() throws IOException {
		connectionToServer = new Socket(IP, TCP);
		objOutStreamToServer = new ObjectOutputStream(connectionToServer.getOutputStream());
		objInStreamFromServer = new ObjectInputStream(connectionToServer.getInputStream());
		Object prompt = null;
		try {
			prompt = objInStreamFromServer.readObject();
		} catch (ClassNotFoundException e) {}
		if (!(prompt instanceof Command) || !(((Command)prompt).equals(Command.GET)))
			throw new ProtocollException("Server does not send command GET after connecting");
	}
	
	private static void shutdownServer() {
		// TODO: here to shutdown server and close connection
	}
	
	private static void sendData(List<Product> products) {
		// TODO: here to send products to server from a list
	}
	
	private static List<Product> receiveData() {
		List<Product> products = new ArrayList<>();
		// TODO: here to receive data from server to a list
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
		printInvestments(demoProducts);
		Tools.tryToWriteXMLFile(new ArrayList<XMLCompatible>(demoProducts), XML_FILE_PATH, "products");
	}
}
