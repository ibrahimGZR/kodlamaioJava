package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.EducationInfo;

public interface EducationInfoDao extends JpaRepository<EducationInfo, Integer> {

}
