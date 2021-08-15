package concretes;

import abstracts.GamerService;
import entities.concretes.Game;

public class GameManager implements GamerService {

	@Override
	public void add(Game game) {
		System.out.println(game.getGameName() + " adlı oyun sisteme eklendi");

	}

	@Override
	public void delete(Game game) {
		System.out.println(game.getGameName() + " adlı oyun silindi");

	}

	@Override
	public void update(Game game) {
		System.out.println(game.getGameName() + " adlı oyun bilgileri güncellendi");

	}

	@Override
	public void addMultiple(Game[] games) {
		for (Game game : games) {
			System.out.println(game.getGameName() + " adlı oyun sisteme eklendi");
		}

	}

}
