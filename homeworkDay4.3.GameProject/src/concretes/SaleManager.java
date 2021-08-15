package concretes;

import abstracts.SaleService;
import entities.concretes.Discount;
import entities.concretes.Game;
import entities.concretes.Sale;

public class SaleManager implements SaleService {

	@Override
	public void add(Sale sale) {
		sale.setSaleDate();
		for (Game game : sale.getGames()) {
			System.out.println(
					"Oyun : " + game.getGameName() + 
					" - Fiyat : " + game.getGamePrice() + 
					" - Alıcı : " + sale.getSaler().getFirstName() +
					" - Satış tarihi : "+ sale.getSaleDate()+ " Satış sisteme eklendi");
		}

	}

	@Override
	public void add(Sale sale, Discount discount) {
		sale.setSaleDate();
		for (Game game : sale.getGames()) {
			System.out.println(
					"Oyun : " + game.getGameName() + 
					" - Fiyat : " + game.getGamePrice()*(100-discount.getDiscountRate())/100 + 
					" - Alıcı : " + sale.getSaler().getFirstName() +
					" - Kapmanya : " +discount.getInfo() +
					" - Satış tarihi : "+ sale.getSaleDate()+ " Satış sisteme eklendi");
		}

	}

	@Override
	public void getAll(Sale[] sales) {
		for (Sale sale : sales) {
			System.out.println(sale.getId()+" numaralı satış listelendi");
		
		}
		 
	}

}
