package com.IssaDev.SpringRest.Rest.services.with.Spring.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldCOntroller {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld (){
        return "Hello World";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Bean Object");
    }

    @GetMapping("hello-world-bean/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello Word Example of  %s", name));
    }
}
