package movies;

import java.util.List;


public class RentManager {

	public static int summarizeIncome(List<Buyable> products)
	{
		int income = 0;
		for (Buyable product: products)
			income += product.getPrice();
		return income;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
