package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	public List<JobPosting> getByActivatedTrue();

	public List<JobPosting> getByActivatedTrueOrderByReleaseDateDesc();

	public List<JobPosting> getByActivatedTrueAndEmployer_CompanyName(String companyName);
}
