package abstracts;

import entities.concretes.Discount;
import entities.concretes.Sale;

public interface SaleService {
	void add(Sale sale);
	
	void add(Sale sale, Discount discount);
	

	void getAll(Sale[] sales);
}
