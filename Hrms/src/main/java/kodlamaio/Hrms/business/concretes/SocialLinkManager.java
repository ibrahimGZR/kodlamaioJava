package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.SocialLinkService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SocialLinkDao;
import kodlamaio.Hrms.entities.concretes.SocialLink;

@Service
public class SocialLinkManager implements SocialLinkService{

	SocialLinkDao socialLinkDao;
	
	@Autowired
	public SocialLinkManager(SocialLinkDao socialLinkDao) {
		super();
		this.socialLinkDao = socialLinkDao;
	}

	@Override
	public DataResult<List<SocialLink>> getAll() {
		return new SuccessDataResult<List<SocialLink>>(this.socialLinkDao.findAll());
	}

	@Override
	public Result add(SocialLink socialLink) {
		this.socialLinkDao.save(socialLink);
		return new SuccessResult();
	}

}