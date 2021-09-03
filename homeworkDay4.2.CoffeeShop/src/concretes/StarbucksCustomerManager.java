package concretes;

import abstracts.BaseCustomerManager;
import abstracts.CustomerCheckService;
import abstracts.CustomerService;
import entities.concretes.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager implements CustomerService {
	CustomerCheckService customerCheckService;

	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;

	}

	@Override
	public void save(Customer customer) {

		if (customerCheckService.checkRealPersonService(customer)) {
			this.save(customer);
			System.out.println("sistem okey");
		} else {
			System.out.println("Not a valid person");
		}

	}
}
