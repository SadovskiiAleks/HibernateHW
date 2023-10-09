package com.example.hibernatehw.controller;

import com.example.hibernatehw.repositories.entity.Persons;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public interface Controller {
    public List  getEntityWithCity(@RequestParam String city);
    public List  getEntityWithAge(@RequestParam int age);
    public Optional<Persons> getEntityWithNameSurname(@RequestParam String name, @RequestParam String surname);

}
