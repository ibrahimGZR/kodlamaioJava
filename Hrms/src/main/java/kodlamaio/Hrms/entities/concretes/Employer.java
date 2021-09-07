package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import kodlamaio.Hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobPostings","user"})
@Table(name = "employers")
public class Employer{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private int employerId;
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;

	@NotNull
	@Column(name = "web_site")
	private String webSite;

	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;

}
