package com.rays.service02.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "service01", url = "http://localhost:8081")
public interface Service01FeignClient {
	
	
	
	
	
	  @PostMapping("/service01/User/submit") 
	  public String submit();
	 

}
