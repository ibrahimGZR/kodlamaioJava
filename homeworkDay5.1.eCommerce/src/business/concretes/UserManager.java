package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public void add(User user) {
		//business code
		userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User getById(int id) {
		
		return userDao.getById(id);
	}

	@Override
	public User getByMail(String email) {
		
		return userDao.getByEmail(email);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

}
