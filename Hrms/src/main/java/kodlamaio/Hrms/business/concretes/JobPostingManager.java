package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobPostingService;
import kodlamaio.Hrms.business.constants.Messages;
import kodlamaio.Hrms.core.utilities.results.*;
import kodlamaio.Hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.Hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {

		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), Messages.jobPostingsListed);
	}

	@Override
	public DataResult<JobPosting> getById(int id) {

		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getById(id), Messages.jobPostingListed);
	}

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(Messages.jobPostingAdded);
	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(Messages.jobPostingUpdated);
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult(Messages.jobPostingDeleted);
	}

	@Override
	public DataResult<List<JobPosting>> getByActivatedTrue() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByActivatedTrue(), "aktif iş ilanları");
	}

	@Override
	public DataResult<List<JobPosting>> getByActivatedTrueOrderByReleaseDateDesc() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByActivatedTrueOrderByReleaseDateDesc(),
				"aktif iş ilanları tarihe göre azalan");
	}

	@Override
	public DataResult<List<JobPosting>> getByActivatedTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(
				this.jobPostingDao.getByActivatedTrueAndEmployer_CompanyName(companyName), "şirkete ait ilan listesi");
	}

	@Override
	public Result jobPostIsActivated(int id) {
		JobPosting jobPosting = this.jobPostingDao.getById(id);
		jobPosting.setActivated(true);
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(Messages.jobPostingUpdated);
	}

	@Override
	public Result jobPostIsPassived(int id) {
		JobPosting jobPosting = this.jobPostingDao.getById(id);
		jobPosting.setActivated(false);
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult(Messages.jobPostingUpdated);
	}

}
