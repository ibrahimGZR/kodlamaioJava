package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EducationInfoService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EducationInfoDao;
import kodlamaio.Hrms.entities.concretes.EducationInfo;

@Service
public class EducationInfoManager implements EducationInfoService{

	EducationInfoDao educationInfoDao;
	
	@Autowired
	public EducationInfoManager(EducationInfoDao educationInfoDao) {
		super();
		this.educationInfoDao = educationInfoDao;
	}

	@Override
	public DataResult<List<EducationInfo>> getAll() {
		return new SuccessDataResult<List<EducationInfo>>(this.educationInfoDao.findAll());
	}

	@Override
	public Result add(EducationInfo educationInfo) {
		this.educationInfoDao.save(educationInfo);
		return new SuccessResult();
	}

}

