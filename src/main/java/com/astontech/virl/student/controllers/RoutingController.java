package com.astontech.virl.student.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {

    @GetMapping("/login")
    public String giveLogin() {return "login";}
}
