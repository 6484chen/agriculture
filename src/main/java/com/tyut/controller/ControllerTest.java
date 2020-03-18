package com.tyut.controller;

import com.tyut.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerTest {

    @GetMapping("/")
    public String test(){
        System.out.println("==========================hello==================");
        return "redirect:home";
    }
    @GetMapping("/home")
    public String home(){
        System.out.println("==========================word==================");
        return "admin/adminIndex";
    }
}
