package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.entities.concretes.User;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;

public interface UserService {
	DataResult<List<User>> getAll();

	DataResult<User> getById(int id);
	
	DataResult<User> getByEmail(String email);

	Result add(User user);

	Result update(User user);

	Result delete(User user);
}
