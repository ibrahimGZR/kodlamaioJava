package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import kodlamaio.Hrms.core.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employers")
public class Employer extends User {

	@JsonIgnore
	@Column(name = "user_id")
	private int userId;
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;

	@NotNull
	@Column(name = "web_site")
	private String webSite;

	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;

}
