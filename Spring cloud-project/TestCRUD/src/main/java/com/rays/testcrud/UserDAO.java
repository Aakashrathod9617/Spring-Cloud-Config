package com.rays.testcrud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@PersistenceContext
	public EntityManager entityManager;

	public long add(UserDTO dto) {

		entityManager.persist(dto);
		return dto.getId();
	}

	public void update(UserDTO dto) {

		entityManager.merge(dto);
	}

	public void delete(UserDTO dto) {
		entityManager.remove(dto);

	}

	public UserDTO get(Long id) {

		return entityManager.find(UserDTO.class, id);
	}
	

	
	 public List<UserDTO> search() {
		 return entityManager.createQuery("SELECT u FROM UserDTO u", UserDTO.class)
                 .getResultList();
	    }
}
