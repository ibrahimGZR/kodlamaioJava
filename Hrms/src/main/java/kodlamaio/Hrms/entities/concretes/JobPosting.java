package kodlamaio.Hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_postings")
public class JobPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_posting_id")
	private int jobPostingId;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;

	@Column(name = "number_of_open_position")
	private int numberOfOpenPosisiton;

	@Column(name = "release_date")
	private Date releaseDate;

	@Column(name = "application_deadline")
	private Date applicationDeadline;

	@Column(name = "activated")
	private boolean activated;

	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
    
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
}
