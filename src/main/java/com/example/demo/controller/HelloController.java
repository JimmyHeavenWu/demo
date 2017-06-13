package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by wuj42 on 6/13/2017.
 */
@RestController
@RequestMapping(value = "/api")
public class HelloController {

    @RequestMapping(path="/v1/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
}
