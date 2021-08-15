package abstracts;

import entities.concretes.Game;

public interface GamerService {
	void add(Game game);

	void delete(Game game);

	void update(Game game);

	void addMultiple(Game[] games);
}
