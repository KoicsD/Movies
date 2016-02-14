package movies;

import java.util.ArrayList;
import java.util.List;


public class RentManager {

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
			System.out.println("\tRender: " + product.getPerson().getFirstName() + " " + product.getPerson().getLastName());
			System.out.println("\tInvestment: " + product.getInvestment());
		}
	}
	
	public static List<Product> generateDemoData()
	{
		List<Product> products = new ArrayList<Product>();

		// movie Matrix
		Movie matrix = new Movie("The Matrix", new Person());
		Person customer = matrix.getPerson();
		customer.setFirstName("Ádám");
		customer.setLastName("Végh");
		customer.setGender(Person.Gender.MALE);
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
		moss.setSalary(800);
		cast.add(moss);
		matrix.setCast(cast);
		matrix.setPrice(10);
		products.add(matrix);
		
		// movie Wolverine
		Movie wolverine = new Movie("Wolverine", new Person());
		customer = wolverine.getPerson();
		customer.setFirstName("Anna");
		customer.setLastName("Gerinczy");
		customer.setGender(Person.Gender.FEMALE);
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
		wolverine.setPrice(11);
		products.add(wolverine);
		
		// book Java
		Book bJava = new Book("Java", matrix.getPerson());
		Person author = new Person();
		author.setFirstName("Bert");
		author.setLastName("Bates");
		author.setGender(Person.Gender.MALE);
		author.setSalary(6000);
		bJava.setAuthor(author);
		products.add(bJava);
		
		// book Fizika
		Book fizika = new Book("A fizika kultúrtörténete", bJava.getPerson());
		author = new Person();
		author.setFirstName("Károly");
		author.setLastName("Simonyi");
		author.setGender(Person.Gender.MALE);
		author.setSalary(4000);
		fizika.setAuthor(author);
		products.add(fizika);
		
		// game Tomb Raider
		Game tombRaider = new Game("Tomb Raider", new Person());
		customer = tombRaider.getPerson();
		customer.setFirstName("Lukács");
		customer.setLastName("Zsóri");
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
		customer = gtaSA.getPerson();
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
	}
}
