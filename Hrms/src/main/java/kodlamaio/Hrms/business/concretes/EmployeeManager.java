package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployeeService;
import kodlamaio.Hrms.business.constants.Messages;
import kodlamaio.Hrms.core.utilities.helpers.VerificationByEmailService;
import kodlamaio.Hrms.core.utilities.results.*;
import kodlamaio.Hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.Hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private VerificationByEmailService verificationByEmailService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, VerificationByEmailService verificationByEmailService) {
		super();
		this.employeeDao = employeeDao;
		this.verificationByEmailService = verificationByEmailService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), Messages.employeesListed);
	}

	@Override
	public DataResult<Employee> getById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.getById(id), Messages.employeeListed);
	}

	@Override
	public Result add(Employee employee) {
		this.verificationByEmailService.send(employee.getEmail(),"Doğrulama Kodu", UUID.randomUUID().toString());
        if (!this.isVerified()){
            return new ErrorResult();
        }
        this.employeeDao.save(employee);
        return new SuccessResult(Messages.employeeAdded);
	}

	@Override
	public Result update(Employee employee) {
		this.verificationByEmailService.send(employee.getEmail(),"Doğrulama Kodu", UUID.randomUUID().toString());
        if (!this.isVerified()){
            return new ErrorResult();
        }
        this.employeeDao.save(employee);
        return new SuccessResult(Messages.employeeUpdated);
	}

	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult(Messages.employeeDeleted);
	}
	
	@Override
	public DataResult<Employee> getByIdentityNumber(String identityNumber) {
		for (Employee employee : this.employeeDao.findAll()) {
			if (employee.getIdentityNumber().equals(identityNumber)) {
				return new SuccessDataResult<Employee>(employee,"bu tc no sistemde kayıtlı");
			}
		}
		 return new ErrorDataResult<Employee>();
	}

	public boolean isVerified() {
		return true;
	}

	

}
