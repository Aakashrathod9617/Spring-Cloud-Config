package com.rays.service02.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.service02.feignclient.Service01FeignClient;

@RestController
@RequestMapping(value = "User")
public class UserCtl {
    
	@Autowired
	public Service01FeignClient service01FeignClient;
	
	@GetMapping("display")
	public String display() {
		return "service02 display method..!!";
	}

	@PostMapping("submit")
	public String submit() {
		/* return "service02 submit method..!!"; */
		
		return service01FeignClient.submit();
	}

}
