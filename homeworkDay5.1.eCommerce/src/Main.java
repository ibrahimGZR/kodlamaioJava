import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.adapters.GoogleAuthManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "İbrahim", "Gezer", "ibrahim@gmail.com", "123456");

		HibernateUserDao userDao = new HibernateUserDao();
		UserManager userManager = new UserManager(userDao);
		GoogleAuthManagerAdapter googleAuthManagerAdapter = new GoogleAuthManagerAdapter();
		AuthManager authManager = new AuthManager(userManager, googleAuthManagerAdapter);

//		 Google ile
//		System.out.println("----------------------google işlemleri");
//		authManager.registerWithGoogle(user.getEmail());
//		authManager.loginWithGoogle(user.getEmail());

		// Auth ile
		 System.out.println("----------------------normal işlemler");
		authManager.register(user);
		authManager.login(user);

		System.out.println("----- Kayıtlı Kullanıcılar -----");
		for (User userr : userManager.getAll()) {
			System.out.println(userr.getFirstName() + " " + userr.getLastName());
		}

	}

}
