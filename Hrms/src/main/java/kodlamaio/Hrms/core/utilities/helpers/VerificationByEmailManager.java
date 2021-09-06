package kodlamaio.Hrms.core.utilities.helpers;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.business.constants.Messages;

@Service
public class VerificationByEmailManager implements VerificationByEmailService {
	@Override
	public Result send(String receiver, String title, String message) {
		return new SuccessResult(Messages.verificationSent);

	}
}
