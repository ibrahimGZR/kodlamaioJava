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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "cvs" })
@Table(name = "education_infos")
public class EducationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_info_id")
	private int educationInfoId;

	@NotBlank
	@NotNull
	@Column(name = "school_name")
	private String schoolName;

	@NotBlank
	@NotNull
	@Column(name = "department_name")
	private String departmentName;

	@NotBlank
	@NotNull
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "finish_date")
	@Nullable
	private Date finishDate;

	@JsonIgnore
	@ManyToMany(mappedBy = "educationInfos")
	private List<Cv> cvs;
}
