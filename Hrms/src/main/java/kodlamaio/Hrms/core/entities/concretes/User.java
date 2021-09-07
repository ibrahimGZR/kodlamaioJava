package kodlamaio.Hrms.core.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import kodlamaio.Hrms.entities.concretes.Employee;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.SystemPersonnel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
	
	@OneToOne(mappedBy = "user")
	private Employee employee;
	
	@OneToOne(mappedBy = "user")
	private Employer employer;
	
	@OneToOne(mappedBy = "user")
	private SystemPersonnel systemPersonnel;
	
	

}
