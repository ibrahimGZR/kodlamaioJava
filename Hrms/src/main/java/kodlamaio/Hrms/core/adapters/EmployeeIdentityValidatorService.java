package kodlamaio.Hrms.core.adapters;

import kodlamaio.Hrms.entities.dtos.EmployeeRegisterDto;

public interface EmployeeIdentityValidatorService {
	boolean isValid(EmployeeRegisterDto employeeRegisterDto);
}
