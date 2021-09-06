package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.business.constants.Messages;
import kodlamaio.Hrms.core.utilities.helpers.VerificationByEmailService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private VerificationByEmailService verificationByEmailService;
	
    @Autowired
	public EmployerManager(EmployerDao employerDao, VerificationByEmailService verificationByEmailService) {
		super();
		this.employerDao = employerDao;
		this.verificationByEmailService = verificationByEmailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),Messages.employersListed);
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).get(),Messages.employerListed);
	}

	@Override
	public Result add(Employer employer) {
		this.verificationByEmailService.send(employer.getEmail(),"Doğrulama Kodu", UUID.randomUUID().toString());
        if (!this.isVerified()){
            return new ErrorResult();
        }
        this.employerDao.save(employer);
        return new SuccessResult(Messages.employerAdded);
	}

	@Override
	public Result update(Employer employer) {
		return new SuccessDataResult<>(this.employerDao.save(employer),Messages.employerUpdated);
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult(Messages.employerDeleted);
	}

	
	public boolean isVerified() {
		return true;
	}

}
