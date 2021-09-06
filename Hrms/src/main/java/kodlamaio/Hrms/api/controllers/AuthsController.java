package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.core.entities.concretes.User;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.EmployeeRegisterDto;
import kodlamaio.Hrms.entities.dtos.EmployerRegisterDto;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {
	AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/employeeregister")
	public Result employeeRegister(@RequestBody EmployeeRegisterDto employeeRegisterDto) {
		return this.authService.employeeRegister(employeeRegisterDto);
	}
	
	@PostMapping("/employerregister")
	public Result employerRegister(@RequestBody EmployerRegisterDto employerRegisterDto) {
		return this.authService.employerRegister(employerRegisterDto);
	}
	
	@PostMapping("/login")
	public Result login(@RequestBody User user) {
		return this.authService.login(user);
	}
	
}
