package com.example.AthenticatedBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AthenticatedBackend.Models.ApplicationUser;
import com.example.AthenticatedBackend.Models.LoginResponseDTO;
import com.example.AthenticatedBackend.Models.RegistraintionDTO;
import com.example.AthenticatedBackend.services.AuthenticationService;
@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistraintionDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistraintionDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}   