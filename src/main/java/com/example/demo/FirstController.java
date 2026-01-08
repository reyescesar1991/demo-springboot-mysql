package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    // @GetMapping("/hello")
    // public String sayHello() {
    //     return "Hello from Spring Boot!";
    // }

    @PostMapping("/post")
    public String post(
        @RequestBody String message
    ){
        return "Request accepted and message is: " + message;
    }

    @PostMapping("/post-order-record")
    public String postRecord(
        @RequestBody OrderRecord order
    ){
        return "Request accepted and order is: " + order.toString();
    }

    @GetMapping("/hello/{user-name}")
    public String pathVar(
        @PathVariable("user-name") String userName
    ) {
        return "my value = " + userName;
    }

    @GetMapping("/hello")
    public String paramVar(
        @RequestParam("user-name")  String userName,
        @RequestParam("user-lastname")  String userLastname
    ) {
        return "my value = " + userName + " " + userLastname;
    }

}
