package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CityService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	CityService cityService;

	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody City city) {
		return this.cityService.update(city);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody City city) {
		return this.cityService.delete(city);
	}
}
