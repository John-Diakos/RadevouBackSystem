package com.back.controller;

//import com.back.model.DAORequest;
import com.back.model.DAOApplication;
import com.back.model.DAOUser;
//import com.back.model.RequestDTO;
import com.back.service.ApplicationService;
import com.back.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subsistent")
@CrossOrigin(origins = "http://localhost:4200")
public class SubsistentController {

    @Autowired
    private ApplicationService applicationService;


    @RequestMapping(value = "/getapplication/{department}", method = RequestMethod.GET)
    public List<DAOApplication> getRequest(@PathVariable String department) throws Exception {
        return applicationService.getRequest(department);
    }


}
