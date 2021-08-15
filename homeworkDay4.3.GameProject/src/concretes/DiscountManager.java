package concretes;

import abstracts.DiscountService;
import entities.concretes.Discount;

public class DiscountManager implements DiscountService {

	@Override
	public void add(Discount discount) {
		System.out.println(discount.getInfo() + " sisteme eklendi");

	}

	@Override
	public void delete(Discount discount) {
		System.out.println(discount.getInfo() + " sistemden silindi");

	}

	@Override
	public void update(Discount discount) {
		System.out.println(discount.getInfo() + " güncellendi");

	}

}
