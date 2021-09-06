package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.business.abstracts.EmployeeService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.business.constants.Messages;
import kodlamaio.Hrms.core.adapters.EmployeeIdentityValidatorService;
import kodlamaio.Hrms.core.utilities.business.*;
import kodlamaio.Hrms.core.entities.concretes.User;
import kodlamaio.Hrms.core.utilities.results.*;
import kodlamaio.Hrms.entities.concretes.Employee;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployeeRegisterDto;
import kodlamaio.Hrms.entities.dtos.EmployerRegisterDto;

@Service
public class AuthManager implements AuthService {
	private UserService userService;
	private EmployeeService employeeService;
	private EmployerService employerService;
	private EmployeeIdentityValidatorService employeeIdentityValidatorService;

	@Autowired
	public AuthManager(UserService userService, EmployeeService employeeService, EmployerService employerService,
			EmployeeIdentityValidatorService employeeIdentityValidatorService) {
		super();
		this.userService = userService;
		this.employeeService = employeeService;
		this.employerService = employerService;
		this.employeeIdentityValidatorService = employeeIdentityValidatorService;
	}

	@Override
	public Result employeeRegister(EmployeeRegisterDto employeeRegisterDto) {
		var result = BusinessRules.run(this.checkEmail(employeeRegisterDto.getEmail()),
				this.checkIdentityNumber(employeeRegisterDto.getIdentityNumber()),
				this.checkIfRealPerson(employeeRegisterDto),
				this.checkPassword(employeeRegisterDto.getPassword(), employeeRegisterDto.getPasswordConfirm()));

		if (result != null) {
			return result;
		}

		var user1 = new User();
		user1.setEmail(employeeRegisterDto.getEmail());
		user1.setPassword(employeeRegisterDto.getPassword());
		var chechVerificationUser = this.userService.add(user1);

		var employee1 = new Employee();
		employee1.setUserId(user1.getUserId());
		employee1.setFirstName(employeeRegisterDto.getFirstName());
		employee1.setLastName(employeeRegisterDto.getLastName());
		employee1.setBirthYear(employeeRegisterDto.getBirthYear());
		employee1.setEmail(user1.getEmail());
		employee1.setPassword(user1.getPassword());
		employee1.setIdentityNumber(employeeRegisterDto.getIdentityNumber());

		var checkVerificationEmployee = this.employeeService.add(employee1);
		if (!checkVerificationEmployee.isSuccess() || !chechVerificationUser.isSuccess()) {
			return new ErrorResult(Messages.verificationFailed);
		}
		return new SuccessResult(Messages.employeeAdded);
	}

	@Override
	public Result employerRegister(EmployerRegisterDto employerRegisterDto) {
		var result = BusinessRules.run(this.checkDomain(employerRegisterDto),
				this.checkEmail(employerRegisterDto.getEmail()),
				this.checkPassword(employerRegisterDto.getPassword(), employerRegisterDto.getPasswordConfirm()));

		if (result != null) {
			return result;
		}

		var user1 = new User();
		user1.setEmail(employerRegisterDto.getEmail());
		user1.setPassword(employerRegisterDto.getPassword());
		
		var chechVerificationUser = this.userService.add(user1);

		var employer1 = new Employer();
		employer1.setUserId(user1.getUserId());
		employer1.setCompanyName(employerRegisterDto.getCompanyName());
		employer1.setPhoneNumber(employerRegisterDto.getPhoneNumber());
		employer1.setEmail(user1.getEmail());
		employer1.setWebSite(employerRegisterDto.getWebsite());
		employer1.setPassword(user1.getPassword());

		var checkVerification = this.employerService.add(employer1);
		if (!checkVerification.isSuccess() || !chechVerificationUser.isSuccess()) {
			return new ErrorResult(Messages.verificationFailed);
		}
		return new SuccessResult(Messages.pendingApproval);
	}

	@Override
	public DataResult<User> login(User user) {
		return null;
	}

	private Result checkIfRealPerson(EmployeeRegisterDto employeeRegisterDto) {
		if (this.employeeIdentityValidatorService.isValid(employeeRegisterDto)) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}

	private Result checkIdentityNumber(String identityNumber) {
		var result = employeeService.getByIdentityNumber(identityNumber);
		if (result.isSuccess()) {
			return new ErrorResult(Messages.identityNumberIsAlreadyInUse);
		}
		return new SuccessResult();
	}

	private Result checkEmail(String email) {
		var result = userService.getByEmail(email);
		if (result.isSuccess()) {
			return new ErrorResult(Messages.emailIsAlreadyInUse);
		}
		return new SuccessResult();
	}

	private Result checkDomain(EmployerRegisterDto employerRegisterDto) {
		var result = employerRegisterDto.getEmail().split("@");
		if (!result[1].equals(employerRegisterDto.getWebsite())) {
			return new ErrorResult(Messages.checkDomain);
		}
		return new SuccessResult();
	}

	private Result checkPassword(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			return new ErrorResult(Messages.passwordsAreIncompatible);
		}
		return new SuccessResult();
	}
}
