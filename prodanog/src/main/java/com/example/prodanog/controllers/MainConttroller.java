package com.example.prodanog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainConttroller {
    @RequestMapping("/")
    public String home(){
        return "Домашняя страница";
    }
}
