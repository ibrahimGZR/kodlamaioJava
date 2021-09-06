package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnels")
public class SystemPersonnelsController {
	SystemPersonnelService systemPersonnelService;

	public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemPersonnel>> getAll() {
		return this.systemPersonnelService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<SystemPersonnel> getById(int id) {
		return this.systemPersonnelService.getById(id);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.update(systemPersonnel);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.delete(systemPersonnel);
	}
}
