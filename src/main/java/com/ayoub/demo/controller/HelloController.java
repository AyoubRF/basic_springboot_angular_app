package com.ayoub.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("ayoubApp")
@RestController
@Api(value = "ayoubApp", description = "This is just a first try")
public class HelloController {

    @GetMapping("hello")
    @ApiOperation(value = "Says hello to user")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("Bye")
    @ApiOperation(value = "Says good bye to user")
    public String sayBye(){
        return "Good Bye";
    }




}



