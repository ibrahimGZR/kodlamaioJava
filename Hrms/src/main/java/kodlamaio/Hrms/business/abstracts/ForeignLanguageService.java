package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	DataResult<List<ForeignLanguage>> getAll();

	Result add(ForeignLanguage foreignLanguage);
}
