package com.example.hibernatehw.controller;

import com.example.hibernatehw.repositories.BaseConnectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class Controller {
    private final BaseConnectRepository baseConnectRepository;

    @GetMapping("/fetch-product")
    public String getProduct(@RequestParam String name) {

        return baseConnectRepository.getProductName(name).toString();

    }
}
