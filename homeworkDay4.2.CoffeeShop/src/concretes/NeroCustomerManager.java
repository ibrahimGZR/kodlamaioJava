package concretes;

import abstracts.BaseCustomerManager;
import abstracts.CustomerService;
import entities.concretes.Customer;

public class NeroCustomerManager extends BaseCustomerManager implements CustomerService{
	@Override
	public void save(Customer customer) {
		System.out.println("Save to db for nero ");
		
	}
}
