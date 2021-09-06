package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();

	DataResult<Employee> getById(int id);
	
	DataResult<Employee> getByIdentityNumber(String identityNumber);

	Result add(Employee employee);

	Result update(Employee employee);

	Result delete(Employee employee);
}
