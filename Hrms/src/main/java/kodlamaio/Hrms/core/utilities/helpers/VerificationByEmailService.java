package kodlamaio.Hrms.core.utilities.helpers;

import kodlamaio.Hrms.core.utilities.results.Result;

public interface VerificationByEmailService {
	Result send(String receiver, String title, String message);
}
