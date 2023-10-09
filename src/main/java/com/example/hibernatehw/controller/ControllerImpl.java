package com.example.hibernatehw.controller;

import com.example.hibernatehw.repositories.CustomRepository;
import com.example.hibernatehw.repositories.entity.Persons;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class ControllerImpl implements Controller {

    private final CustomRepository customRepository;

    @Override
    @GetMapping("/by-city")
    public List getEntityWithCity(@RequestParam String city) {
        return customRepository.findByCityOfLivingContains(city);
    }

    @Override
    @GetMapping("/by-age")
    public List getEntityWithAge(@RequestParam int age) {
        return customRepository.findPersonsByUser_AgeGreaterThanOrderByUserAsc(age);
    }

    @Override
    @GetMapping("/by-name-and-surname")
    public Optional<Persons> getEntityWithNameSurname(@RequestParam String name, @RequestParam String surname) {
        return customRepository.findPersonsByUser_NameAndUser_Surname(name, surname);
    }
}
