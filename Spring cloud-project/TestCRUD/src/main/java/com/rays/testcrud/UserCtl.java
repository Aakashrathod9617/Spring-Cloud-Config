package com.rays.testcrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "User")
public class UserCtl {
	@Autowired
	private UserService service;

	 
	
	@GetMapping("display")
	public String display() {
		return "service02 display method..!!";
	}
    @PostMapping("save")
    public String save(@RequestBody UserForm form) {
    	
    	
    	UserDTO dto=new UserDTO();
    	dto.setId(form.getId());
    	dto.setFirstName(form.getFirstName());
    	dto.setLastName(form.getLastName());
    	dto.setLoginId(form.getLoginId());
    	dto.setPassword(form.getPassword());
    	if (dto.getId()>0) {
			service.update(dto);;
		} else {
			service.add(dto);

		}
    	       
    	
    	 return ("User Add");
    }   

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id ,@RequestBody UserForm form) {
    	
    	System.out.println("in");
    	service.delete(id);
    	
    	return "Data Deleted chacke DB";
    }
    
    @GetMapping("/get/{id}")
	public UserDTO get(@PathVariable(value = "id") Long id, @RequestBody UserForm form) {

		UserDTO dto = service.findById(id);

		return dto;
	}
    
    @GetMapping("/search")
    public List<UserDTO> search(){
		return service.search();
    	
    }
    
	    
}
