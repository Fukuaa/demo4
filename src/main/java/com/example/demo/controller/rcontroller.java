package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class rcontroller {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "views/login";
    }

    @RequestMapping("/l1/{id}")
    public String l1(@PathVariable("id") int id){
        return "views/l1/"+id;
    }
    @RequestMapping("/l2/{id}")
    public String l2(@PathVariable("id") int id){
        return "views/l2/"+id;
    }
    @RequestMapping("/l3/{id}")
    public String l3(@PathVariable("id") int id){
        return "views/l3/"+id;
    }
    /*@GetMapping("/403")
    public String show403() {
        return "403";
    }*/
}
