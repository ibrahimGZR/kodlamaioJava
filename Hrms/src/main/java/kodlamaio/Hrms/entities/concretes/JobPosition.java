package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "job_positions")
public class JobPosition {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "position_name")
	private String positionName;
}
