package com.example.springbootsample.app;


import com.example.springbootsample.domain.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncRestController {


    @Autowired
    AsyncService service;

    @GetMapping("/sync")
    public String sync(){
        System.out.println("controller start.");
        service.sync();
        System.out.println("controller end.");
        return "hello";
    }

    @GetMapping("/async")
    public String async(){
        System.out.println("controller start.");
        int i = service.async();
        System.out.println("controller end.");
        return "hello" + i + 1;
    }

}
