package com.example.demo;

import gui.RobotsProgram;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreatingController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){

        return "hello";
    }
}
