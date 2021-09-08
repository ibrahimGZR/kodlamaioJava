package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CityService;
import kodlamaio.Hrms.business.constants.Messages;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CityDao;
import kodlamaio.Hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), Messages.citiesListed);
	}

	@Override
	public DataResult<City> getById(int id) {

		return new SuccessDataResult<City>(this.cityDao.getById(id),Messages.cityListed);
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
        return new SuccessResult(Messages.cityAdded);
	}

	@Override
	public Result update(City city) {
		this.cityDao.save(city);
        return new SuccessResult(Messages.cityUpdated);
	}

	@Override
	public Result delete(City city) {
		this.cityDao.delete(city);
        return new SuccessResult(Messages.cityDeleted);
	}

}
