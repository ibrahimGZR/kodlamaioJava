package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.SocialLink;

public interface SocialLinkService {
	DataResult<List<SocialLink>> getAll();

	Result add(SocialLink socialLink);
}
