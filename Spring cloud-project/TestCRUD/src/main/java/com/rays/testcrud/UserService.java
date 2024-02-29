package com.rays.testcrud;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
@Transactional
public class UserService{

	@Autowired
	public UserDAO dao;
	
	public long add(UserDTO dto) {
		return dao.add(dto);
	}
	
	public void update(UserDTO dto) {
		
		dao.update(dto);
	}
	@Transactional
	public void delete(Long id) {
		UserDTO dto= dao.get(id);
		if (dto == null) {
			throw new RuntimeException("Record not found...!!!");
		}
		dao.delete(dto);
	}
	
	
	public UserDTO findById(Long id) {
		
		UserDTO dto=dao.get(id);
		
		return dto;
	}
	
	public List<UserDTO> search(){
		return dao.search();
		
	}
	
	}


