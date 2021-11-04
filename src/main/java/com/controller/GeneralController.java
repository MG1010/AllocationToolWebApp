package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping(value = "*")
    public String showDefaultPage() {
        return "home";
    }

    @GetMapping(value = "/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping(value = "/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping(value = "/team")
    public String showTeamPage() {
        return "home";
    }

}