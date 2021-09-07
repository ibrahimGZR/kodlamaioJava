package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();

	DataResult<JobPosting> getById(int id);

	Result add(JobPosting jobPosting);

	Result update(JobPosting jobPosting);

	Result delete(JobPosting jobPosting);

	DataResult<List<JobPosting>> getByActivatedTrue();

	DataResult<List<JobPosting>> getByActivatedTrueOrderByReleaseDateDesc();

	DataResult<List<JobPosting>> getByActivatedTrueAndEmployer_CompanyName(String companyName);
	
	Result jobPostIsActivated(int id);
	
	Result jobPostIsPassived(int id);
	
}
