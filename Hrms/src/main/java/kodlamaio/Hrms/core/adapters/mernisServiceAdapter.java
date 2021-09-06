package kodlamaio.Hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.entities.dtos.EmployeeRegisterDto;
import mernis.MernisService;

@Service
public class mernisServiceAdapter implements EmployeeIdentityValidatorService {

	@Override
	public boolean isValid(EmployeeRegisterDto employeeRegisterDto) {
		MernisService mernisService = new MernisService();

		return mernisService.tcKimlikDogrula(Long.parseLong(employeeRegisterDto.getIdentityNumber()), employeeRegisterDto.getFirstName(),
				employeeRegisterDto.getLastName(), employeeRegisterDto.getBirthYear());
	}

}