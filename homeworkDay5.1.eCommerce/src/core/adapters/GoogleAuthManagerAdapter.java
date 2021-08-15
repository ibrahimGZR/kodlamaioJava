package core.adapters;

import googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AccAuthService {

	private GoogleAuthManager googleAuthManager = new GoogleAuthManager();

	@Override
	public void register(String email) {
		googleAuthManager.register(email);
	}

	@Override
	public void login(String email) {
		googleAuthManager.login(email);
	}

	

}
