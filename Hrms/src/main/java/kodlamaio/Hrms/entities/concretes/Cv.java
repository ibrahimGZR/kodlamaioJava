package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv")
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private int cvId;

	@Column(name = "cv_name")
	private String cvName;

	@ManyToOne()
	@JoinColumn(name = "cover_letter_id")
	private CoverLetter coverLetter;

	@ManyToOne()
	@JoinColumn(name = "photo_id")
	private Photo photo;

	@ManyToMany()
	@JoinTable(name = "cv_education_infos", 
	joinColumns = @JoinColumn(name = "cv_id"), 
	inverseJoinColumns = @JoinColumn(name = "education_info_id"))
	private List<EducationInfo> educationInfos;

	@ManyToMany()
	@JoinTable(name = "cv_social_links", 
	joinColumns = @JoinColumn(name = "cv_id"), 
	inverseJoinColumns = @JoinColumn(name = "social_link_id"))
	private List<SocialLink> socialLinks;

	@ManyToMany()
	@JoinTable(name = "cv_foreign_languages", 
	joinColumns = @JoinColumn(name = "cv_id"), 
	inverseJoinColumns = @JoinColumn(name = "foreign_language_id"))
	private List<ForeignLanguage> foreignLanguages;

	@ManyToMany()
	@JoinTable(name = "cv_job_experiences", 
	joinColumns = @JoinColumn(name = "cv_id"), 
	inverseJoinColumns = @JoinColumn(name = "job_experience_id"))
	private List<JobExperience> jobExperiences;

	@ManyToMany()
	@JoinTable(name = "cv_abilities", 
	joinColumns = @JoinColumn(name = "cv_id"), 
	inverseJoinColumns = @JoinColumn(name = "ability_id"))
	private List<Ability> abilities;

	@ManyToOne()
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
