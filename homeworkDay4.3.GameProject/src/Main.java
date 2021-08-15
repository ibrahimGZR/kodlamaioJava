import adapters.MernisServiceAdapter;
import concretes.DiscountManager;
import concretes.GameManager;
import concretes.SaleManager;
import concretes.SalerManager;
import entities.concretes.Discount;
import entities.concretes.Game;
import entities.concretes.Sale;
import entities.concretes.Saler;

public class Main {

	public static void main(String[] args) {
		SalerManager salerManager = new SalerManager(new MernisServiceAdapter());
		Saler saler1 = new Saler(1, "ibrahim", "gezer", "12121212121", 1992);

		salerManager.add(saler1);

		System.out.println("---OYUN İŞLEMLERİ : ");

		GameManager gameManager = new GameManager();

		Game game1 = new Game(1, "CS:GO", 100);

		Game game2 = new Game(2, "Left 4 Dead ", 78);

		gameManager.add(game1);
		gameManager.add(game2);

		System.out.println("---MULTİPLE OYUN EKLEME İŞLEMİ : ");

		Game[] games = { game1, game2 };
		gameManager.addMultiple(games);

		System.out.println("---İNDİRİM İŞLEMLERİ : ");

		DiscountManager discountManager = new DiscountManager();

		Discount indirim1 = new Discount(30, "Sezon indirimi");

		Discount indirim2 = new Discount(50, "Büyük Kampanya  indirimi");

		discountManager.add(indirim1);
		discountManager.add(indirim2);
		discountManager.delete(indirim2);

		System.out.println("---SATIŞ İŞLEMLERİ : ");

		SaleManager saleManager = new SaleManager();

		Sale sale1 = new Sale();
		sale1.setId(1);
		sale1.setGames(games);
		sale1.setSaler(saler1);

		Sale sale2 = new Sale();
		sale2.setId(2);
		sale2.setGames(games);
		sale2.setSaler(saler1);

		Sale[] sales = new Sale[] { sale1, sale2 };

		saleManager.add(sale1, indirim1);
		saleManager.add(sale2, indirim2);
		saleManager.getAll(sales);

	}

}
