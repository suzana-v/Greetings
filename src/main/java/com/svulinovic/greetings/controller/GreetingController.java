package com.svulinovic.greetings.controller;

import com.svulinovic.greetings.config.AppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final AppConfig appConfig;

    public GreetingController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/greeting")
    public String greet(@RequestParam String name) {
        return appConfig.getGreeting().getGreeting() + ", " + name + "!";
    }
}
