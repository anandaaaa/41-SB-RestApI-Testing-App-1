package in.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.anand.service.WelcomeService;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private WelcomeService welcomeservice;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome()
	{
	
		String welcomeMsg = welcomeservice.welcomeMsg();
		return new ResponseEntity(welcomeMsg,HttpStatus.OK);
	}
	

}
