package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EducationInfoService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.EducationInfo;

@RestController
@RequestMapping("/api/educationinfos")
public class EducationInfosController {
	EducationInfoService educationInfoService;

	@Autowired
	public EducationInfosController(EducationInfoService educationInfoService) {
		super();
		this.educationInfoService = educationInfoService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EducationInfo>> getAll() {
		return this.educationInfoService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationInfo educationInfo) {
		return this.educationInfoService.add(educationInfo);
	}
}
