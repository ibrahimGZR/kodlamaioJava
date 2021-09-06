package kodlamaio.Hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	

}
