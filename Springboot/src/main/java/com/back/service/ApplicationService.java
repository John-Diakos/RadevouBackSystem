package com.back.service;

import com.back.dao.ApplicationDao;
//import com.back.dao.RequestDao;
import com.back.dao.UserDao;
import com.back.dao.UserForRegistrationDao;
import com.back.model.*;
//import com.back.model.DAORequest;
//import com.back.model.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private UserForRegistrationDao userForRegistrationDao;


    public ApplicationService(ApplicationDao applicationDao, UserForRegistrationDao userForRegistrationDao) {
        this.applicationDao = applicationDao;
        this.userForRegistrationDao = userForRegistrationDao;
    }

    public DAOApplication save(ApplicationDTO req){
            DAOApplication daoApplication = new DAOApplication();
            daoApplication.setApprove(req.isApprove());
            daoApplication.setDateOfCheck(req.getDateOfCheck());
            daoApplication.setDateOfSubm(req.getDateOfSubm());
            daoApplication.setTitle(req.getTitle());
            daoApplication.setDateOfApp(req.getDateOfApp());
            daoApplication.setDepartment(req.getDepartment());
            daoApplication.setUserId(req.getUserId());
            applicationDao.save(daoApplication);
        return daoApplication;
    }

    public DAOApplication save(DAOApplication req){
        applicationDao.save(req);
        return req;
    }

    public DAOApplication existApplication(ApplicationDTO req){
        DAOApplication daoRequestRet = applicationDao.findByTitleAndDepartment(req.getTitle(),req.getDepartment());
        return daoRequestRet;
    }

    public List<String> getDepartment(){
        List<String> listDepartment = new ArrayList<>();
        List<DAOUser> daoUsers = userDao.findAll();
        for (DAOUser d:daoUsers
             ) {
            listDepartment.add(d.getDepartment());
        }
        return listDepartment.stream().distinct().collect(Collectors.toList());
    }

    public String save(List<UserForRegistrationDTO> requst){
        for (UserForRegistrationDTO req: requst
             ) {
            DAOUserForRegistration daoApplication = new DAOUserForRegistration();
            daoApplication.setAfm(req.getAfmDepartment());
            daoApplication.setFirstName(req.getFirstName());
            daoApplication.setLastName(req.getLastName());
            daoApplication.setRole(req.getRole());
            daoApplication.setDepartment(req.getDepartment());
            userForRegistrationDao.save(daoApplication);
        }

        return "Ok";
    }

    public List<UserForRegistrationDTO> getUserForRegister(){
        List<DAOUserForRegistration> list = userForRegistrationDao.findAll();
        List<UserForRegistrationDTO> userForRegistrationDTOS = new ArrayList<>();
        for (DAOUserForRegistration dao: list
             ) {
            UserForRegistrationDTO userForRegistrationDTO = new UserForRegistrationDTO();
            userForRegistrationDTO.setDepartment(dao.getDepartment());
            userForRegistrationDTO.setFirstName(dao.getFirstName());
            userForRegistrationDTO.setLastName(dao.getLastName());
            userForRegistrationDTO.setRole(dao.getRole());
            userForRegistrationDTO.setId(dao.getId());
            userForRegistrationDTOS.add(userForRegistrationDTO);
        }

        return userForRegistrationDTOS;
    }

    public void delete(UserForRegistrationDTO user) {
        DAOUserForRegistration newUser = userForRegistrationDao.findAllById(user.getId());
        userForRegistrationDao.delete(newUser);
    }

    public List<DAOApplication> getRequest(String departement){
        return applicationDao.findByDepartment(departement);
    }


}
