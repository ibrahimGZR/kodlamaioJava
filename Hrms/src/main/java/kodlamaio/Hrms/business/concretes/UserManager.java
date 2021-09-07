package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.core.dataAccess.UserDao;
import kodlamaio.Hrms.core.entities.concretes.User;
import kodlamaio.Hrms.core.utilities.results.*;

@Service
public class UserManager implements UserService {

	UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult();
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email), "bu email sistemde kayıtlı");
	}

}
