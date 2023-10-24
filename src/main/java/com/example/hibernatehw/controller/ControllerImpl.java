package com.example.hibernatehw.controller;

import com.example.hibernatehw.repositories.RepositoryImpl;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class ControllerImpl implements Controller {

    private final RepositoryImpl repositoryImpl;


    @GetMapping("/userName")
    public String GetUser() {
        return "Name: user, password: password";
    }

    @GetMapping("/by-city")
    public List testGetContr2(@RequestParam String city) {
        return repositoryImpl.getPersonsByCity(city);
    }

    //"READ"
    @Secured({"ROLE_READ"})
    @GetMapping("/user")
    public List getUserByName(@RequestParam String name){
        return repositoryImpl.getUserByName(name);
    }

    // "WRITE"
    @RolesAllowed({"WRITE"})
    @GetMapping("/addUser")
    public boolean addUser(@RequestParam String name, @RequestParam String surname){
        return repositoryImpl.addNewUser(name,surname);
    }

    // "DELETE"
    @GetMapping("/deleteUser")
    public boolean deleteUser(@RequestParam String name, @RequestParam String surname){
        return repositoryImpl.deleteUser(name,surname);
    }

    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @GetMapping("/preAuthorize")
    public String preAuthorize(){
        System.out.println("Test");
        return "preAuthorize";
    }

    @PostAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @GetMapping("/postAuthorize")
    public String postAuthorize(){
        System.out.println("Test");
        return "postAuthorize";
    }

    @GetMapping("/asUserAuthentication")
    @PreAuthorize("#username == authentication.principal.username")
    public String asUserAuthentication(@RequestParam String username){
        return "All OK " + username;
    }
}
