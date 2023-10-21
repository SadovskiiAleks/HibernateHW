package com.example.hibernatehw.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface Controller {

    public List testGetContr2(@RequestParam String city);


}
