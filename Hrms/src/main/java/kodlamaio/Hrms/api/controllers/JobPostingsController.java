package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobPostingService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingsController {
	JobPostingService jobPostingService;

	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}

	@PostMapping("/update")
	public Result update(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.update(jobPosting);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.delete(jobPosting);
	}

	@GetMapping("/getByActivatedTrue")
	public DataResult<List<JobPosting>> getByActivatedTrue() {
		return this.jobPostingService.getByActivatedTrue();
	}

	@GetMapping("/getByActivatedTrueOrderByReleaseDateDesc")
	public DataResult<List<JobPosting>> getByActivatedTrueOrderByReleaseDateDesc() {
		return this.jobPostingService.getByActivatedTrueOrderByReleaseDateDesc();
	}

	@GetMapping("/getByEmployer_CompanyName")
	public DataResult<List<JobPosting>> getByEmployer_CompanyName(@RequestParam String companyName) {
		return this.jobPostingService.getByActivatedTrueAndEmployer_CompanyName(companyName);
	}
	
	@PostMapping("/jobPostIsActivated")
	public Result jobPostIsActivated(@RequestParam int id) {
		return this.jobPostingService.jobPostIsActivated(id);
	}
	
	@PostMapping("/jobPostIsPassived")
	public Result jobPostIsPassived(@RequestParam int id) {
		return this.jobPostingService.jobPostIsPassived(id);
	}
}
