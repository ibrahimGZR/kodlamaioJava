package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Ability;

public interface AbilityService {
	DataResult<List<Ability>> getAll();

	Result add(Ability ability);
}
