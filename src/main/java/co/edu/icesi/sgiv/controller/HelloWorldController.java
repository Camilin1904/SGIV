package co.edu.icesi.sgiv.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(maxAge = 3600)
public class HelloWorldController {

    @RequestMapping("hello/{name}")
    public String helloWorld(@PathVariable(value="name") String name) {
        if(name == null){
            return "Hello world!!";
        }
        return "Hello "+name+"!!";
    }
}