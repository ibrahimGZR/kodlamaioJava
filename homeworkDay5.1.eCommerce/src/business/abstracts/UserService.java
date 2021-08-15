package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {
	void add(User user);

	void update(User user);

	void delete(User user);

	User getById(int id);

	User getByMail(String email);

	List<User> getAll();

}
