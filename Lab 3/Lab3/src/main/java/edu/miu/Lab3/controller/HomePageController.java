package edu.miu.Lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {

    @GetMapping(value = {"/", "/elibrary", "/elibrary/home"})
    public String getHomePage() {
        return "home/index";
    }
}