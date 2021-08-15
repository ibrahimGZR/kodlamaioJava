package business.concretes;

import java.util.Scanner;
import java.util.UUID;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.constants.Messages;
import business.validationRules.UserValidator;
import core.adapters.AccAuthService;
import core.utils.business.BusinessRules;
import core.utils.results.Result;
import entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;
	private AccAuthService accAuthService;

	public AuthManager(UserService userService, AccAuthService accAuthService) {
		super();
		this.userService = userService;
		this.accAuthService = accAuthService;
	}

	@Override
	public void register(User user) {
		Result result = BusinessRules.run(userExists(user.getEmail()), UserValidator.checkPassword(user.getPassword()),
				UserValidator.checkFirstName(user.getFirstName()), UserValidator.checkLastName(user.getLastName()),
				UserValidator.emailRegex(user.getEmail()));

		if (result.isSuccess()) {
			this.sendMail(user.getEmail());
			if (clickOnTheLink().isSuccess()) {
				var newUser = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
						user.getPassword());
				userService.add(newUser);
				Messages.userRegister(user.getFirstName());
			}
		}

	}

	@Override
	public void login(User user) {
		var userToCheck = userService.getByMail(user.getEmail());
		if (userToCheck == null) {
			Messages.userNotFound();
		} else if (userToCheck.getPassword() == user.getPassword()) {
			Messages.userLogin(user.getFirstName());
		} else {
			Messages.wrongPassword();
		}

	}

	@Override
	public Result userExists(String email) {
		if (userService.getByMail(email) != null) {
			Messages.userAlreadyExists();
			return new Result(false);
		}
		return new Result(true);

	}

	@Override
	public void sendMail(String email) {
		Messages.sendEmail(email);

	}

	public void randomEmailCodeGenerator() {
		String uuid = UUID.randomUUID().toString();
		Messages.sendEmailCode(uuid);
	}

	public Result clickOnTheLink() {
		var scanner = new Scanner(System.in);
		Messages.clickOnTheLink();
		String message = scanner.nextLine();
		scanner.close();
		if (message.equals("y") || message.equals("Y")) {
			this.randomEmailCodeGenerator();
			return new Result(true);
		} else {
			Messages.verificationFailed();
			return new Result(false);
		}
	}

	@Override
	public void registerWithGoogle(String email) {
		Result result = BusinessRules.run(UserValidator.emailRegex(email));
		if (result.isSuccess()) {
			this.sendMail(email);
			if (clickOnTheLink().isSuccess()) {
				var newUser = new User(101, "google'dan çekilen isim isim", "google'dan çekilen soyisim isim", email,
						"google123");
				userService.add(newUser);
				accAuthService.register(email);
			}
		}

	}

	@Override
	public void loginWithGoogle(String email) {
		Result result = BusinessRules.run(UserValidator.emailRegex(email));
		if (result.isSuccess()) {
			accAuthService.login(email);
		}

	}

}
