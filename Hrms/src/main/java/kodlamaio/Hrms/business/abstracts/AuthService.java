package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.entities.concretes.User;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.EmployeeRegisterDto;
import kodlamaio.Hrms.entities.dtos.EmployerRegisterDto;

public interface AuthService {
	Result employeeRegister(EmployeeRegisterDto employeeRegisterDto);

	Result employerRegister(EmployerRegisterDto employerRegisterDto);

	DataResult<User> login(User user);
}
