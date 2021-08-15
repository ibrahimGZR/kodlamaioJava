package business.abstracts;

import core.utils.results.Result;
import entities.concretes.User;

public interface AuthService {

	void register(User user);

	void login(User user);
	
	void registerWithGoogle(String email);
	
	void loginWithGoogle(String email);

	Result userExists(String email);

	void sendMail(String email);
}
