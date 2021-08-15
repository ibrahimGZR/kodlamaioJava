package abstracts;

import entities.concretes.Discount;

public interface DiscountService {
	void add(Discount discount);

	void delete(Discount discount);

	void update(Discount discount);
}
