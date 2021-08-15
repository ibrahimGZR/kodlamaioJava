package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {

	private List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByEmail(String email) {

		for (User user : users) {
			if (user.getEmail()==email) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

}
