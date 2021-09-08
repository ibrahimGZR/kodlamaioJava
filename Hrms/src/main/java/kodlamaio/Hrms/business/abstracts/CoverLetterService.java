package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	DataResult<List<CoverLetter>> getAll();

	Result add(CoverLetter coverLetter);
}
