package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CvService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
	CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}
	
	@GetMapping("/getbyemployeeid")
	public DataResult<List<Cv>> getByEmployee_EmployeeId(@RequestParam int id) {
		return this.cvService.getByEmployee_EmployeeId(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
}
