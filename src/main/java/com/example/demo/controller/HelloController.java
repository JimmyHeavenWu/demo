package com.example.demo.controller;

import com.example.demo.domain.ValidationObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


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

    @ApiOperation(value = "This is a just a simple spring validation feature test.")
    @RequestMapping(value="/v1/validation", method = RequestMethod.POST)
    public String validate(@Valid @RequestBody ValidationObject object) {
        return "valid";
    }
}
