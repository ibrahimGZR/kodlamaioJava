package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.EducationInfo;

public interface EducationInfoService {
	DataResult<List<EducationInfo>> getAll();

	Result add(EducationInfo educationInfo);
}
