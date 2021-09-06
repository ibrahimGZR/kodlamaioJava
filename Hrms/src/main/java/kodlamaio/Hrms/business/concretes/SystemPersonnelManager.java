package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.Hrms.business.constants.Messages;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlamaio.Hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {
	private SystemPersonnelDao systemPersonnelDao;

	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(),
				Messages.systemPersonnelListed);
	}

	@Override
	public DataResult<SystemPersonnel> getById(int id) {
		return new SuccessDataResult<>(this.systemPersonnelDao.findById(id).get());
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.save(systemPersonnel);
        return new SuccessResult(Messages.systemPersonnelAdded);
	}

	@Override
	public Result update(SystemPersonnel systemPersonnel) {
		return new SuccessDataResult<>(this.systemPersonnelDao.save(systemPersonnel));
	}

	@Override
	public Result delete(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.delete(systemPersonnel);
		return new SuccessResult(Messages.systemPersonnalDeleted);
	}

}