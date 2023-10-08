//package com.example.hibernatehw.controller;
//
//import com.example.hibernatehw.repositories.RepositoryImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("persons")
//@RequiredArgsConstructor
//public class ControllerImpl implements Controller {
//
//    private final RepositoryImpl repositoryImpl;
//
//    @GetMapping("/by-city")
//    public List testGetContr2(@RequestParam String city) {
//        return repositoryImpl.getPersonsByCity(city);
//    }
//}
