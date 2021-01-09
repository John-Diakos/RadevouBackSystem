package com.back.dao;

import com.back.model.DAOApplication;
//import com.back.model.DAORequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationDao extends CrudRepository<DAOApplication, Integer> {

    DAOApplication findByTitleAndDepartment(String title, String department);

    DAOApplication findById(long id);

    List<DAOApplication> findByDepartment(String department);

    List<DAOApplication> findAll();

}