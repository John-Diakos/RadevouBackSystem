package com.back.controller;

//import com.back.model.DAORequest;
import com.back.model.ApplicationDTO;
import com.back.model.DAOApplication;
import com.back.model.UserForRegistrationDTO;
import com.back.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisior")
@CrossOrigin(origins = "http://localhost:4200")
public class SupervisiorController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/application", method = RequestMethod.POST)
    public ResponseEntity<?> saveApplication(@RequestBody List<UserForRegistrationDTO> req) throws Exception {
         return ResponseEntity.ok(applicationService.save(req));
    }


}
