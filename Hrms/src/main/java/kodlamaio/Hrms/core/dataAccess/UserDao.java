package kodlamaio.Hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.Hrms.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	@Query("From User where email=:email")
	public User getByEmail(String email);

}
