package com.eshop.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloController {

    @Get(value = "/hello", produces = MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello world!";
    }
}
