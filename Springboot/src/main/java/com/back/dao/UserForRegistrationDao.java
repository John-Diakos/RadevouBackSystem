package com.back.dao;

import com.back.model.DAOUser;
import com.back.model.DAOUserForRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserForRegistrationDao extends CrudRepository<DAOUserForRegistration, Integer> {


	List<DAOUserForRegistration> findAll();

	DAOUserForRegistration findAllById(long id);

	List<DAOUserForRegistration> findAllByRole(String role);
}