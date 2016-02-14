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
		// data dumper code comes here
		return products;
	}
	
	public static void main(String[] args) {
		List<Product> demoProducts = generateDemoData();
		printInvestments(demoProducts);
	}
}
