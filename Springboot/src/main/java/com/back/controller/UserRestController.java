package com.back.controller;


import com.back.model.ApplicationDTO;
import com.back.model.DAOApplication;
import com.back.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

    @Autowired
    private ApplicationService applicationService;


    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public String saveApplication(@RequestBody ApplicationDTO req) throws Exception {
        DAOApplication daoApplication = applicationService.existApplication(req);
        if(daoApplication != null){
            daoApplication.setDateOfSubm(new Date());
            daoApplication.setApprove(false);
            applicationService.save(daoApplication);
        }else{
            req.setDateOfSubm(new Date());
            req.setApprove(false);
            applicationService.save(req);
        }
        return "OK";
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<String> getDepartment() throws Exception {
        return applicationService.getDepartment();
    }

}
