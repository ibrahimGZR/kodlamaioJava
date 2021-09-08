package kodlamaio.Hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvs"})
@Table(name = "job_experiences")
public class JobExperience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_experience_id")
	private int jobExperienceId;

	@NotBlank
	@NotNull
	@Column(name = "workplace_name")
	private String workplaceName;

	@NotBlank
	@NotNull
	@Column(name = "position_name")
	private String positionName;

	@NotBlank
	@NotNull
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "finish_date")
	@Nullable
	private Date finishDate;

	@JsonIgnore
	@ManyToMany(mappedBy = "jobExperiences")
	private List<Cv> cvs;
}
