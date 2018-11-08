package com.sik.pattest.controller;

import com.sik.pattest.service.PatDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private PatDataService patDataService;
 
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("customers", patDataService.getAllCustomers());
        return "home";
    }
}
