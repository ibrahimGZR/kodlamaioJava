package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer> {

}
