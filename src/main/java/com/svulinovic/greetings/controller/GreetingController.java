package com.svulinovic.greetings.controller;

import com.svulinovic.greetings.component.Greeter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final Greeter greeter;

    public GreetingController(Greeter greeter) {
        this.greeter = greeter;
    }

    @GetMapping("/greeting")
    public String greet(@RequestParam String name) {
        return greeter.greet(name);
    }
}
