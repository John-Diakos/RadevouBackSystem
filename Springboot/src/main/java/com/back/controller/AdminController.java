package com.back.controller;

import com.back.model.DAOUser;
import com.back.model.UserDTO;
import com.back.model.UserForRegistrationDTO;
import com.back.service.ApplicationService;
import com.back.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    public AdminController(ApplicationService applicationService, JwtUserDetailsService userDetailsService) {
        this.applicationService = applicationService;
        this.userDetailsService = userDetailsService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteUser(@RequestBody UserDTO user) throws Exception {
        userDetailsService.delete(user);
        return ResponseEntity.ok(userDetailsService.getUsers());
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseEntity<?> modifyUser(@RequestBody UserDTO user) throws Exception {
        System.out.println(user);
        return ResponseEntity.ok(userDetailsService.update(user));
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    public ResponseEntity<?> activateUser(@RequestBody UserDTO user) throws Exception {
        return   ResponseEntity.ok(userDetailsService.activate(user));
    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public List<DAOUser> getUserList() throws Exception {
        return   userDetailsService.getUsers();
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.POST)
    public DAOUser getUserList(@RequestBody UserDTO user) throws Exception {
        return   userDetailsService.getUser(user.getId());
    }

    @RequestMapping(value = "/getuserforregister", method = RequestMethod.GET)
    public List<UserForRegistrationDTO> getUserForRegister() throws Exception {
        return   applicationService.getUserForRegister();
    }

    @RequestMapping(value = "/deleteReg", method = RequestMethod.POST)
    public ResponseEntity<?> deleteRegisterUser(@RequestBody UserForRegistrationDTO user) throws Exception {
        applicationService.delete(user);
        return ResponseEntity.ok(applicationService.getUserForRegister());
    }

}
