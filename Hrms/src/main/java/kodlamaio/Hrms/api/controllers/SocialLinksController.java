package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.SocialLinkService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.SocialLink;

@RestController
@RequestMapping("/api/sociallinks")
public class SocialLinksController {
	SocialLinkService socialLinkService;

	@Autowired
	public SocialLinksController(SocialLinkService socialLinkService) {
		super();
		this.socialLinkService = socialLinkService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SocialLink>> getAll() {
		return this.socialLinkService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialLink socialLink) {
		return this.socialLinkService.add(socialLink);
	}
}
