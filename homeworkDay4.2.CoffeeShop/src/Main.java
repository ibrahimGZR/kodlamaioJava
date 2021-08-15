import abstracts.BaseCustomerManager;
import adapters.MernisServiceAdapter;
import concretes.NeroCustomerManager;
import concretes.StarbucksCustomerManager;
import entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		// for starbucks customer

		BaseCustomerManager customermanager = new StarbucksCustomerManager(new MernisServiceAdapter());

		customermanager.save(new Customer(3, "İbrahim", "Gezer", 1992, "12121212121"));

		// for nero customer
		BaseCustomerManager customermanager2 = new NeroCustomerManager();

		customermanager2.save(new Customer(2, "İbrahim", "Gezer", 1992, "12121212121"));

	}

}
