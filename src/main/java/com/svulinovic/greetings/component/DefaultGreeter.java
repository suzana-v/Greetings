package com.svulinovic.greetings.component;

import com.svulinovic.greetings.config.AppConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "greeter",
        havingValue = "default",
        matchIfMissing = true
)
public class DefaultGreeter implements Greeter {

    private final AppConfig appConfig;

    public DefaultGreeter(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public String greet(String name) {
        return appConfig.getGreeting().getGreeting() + ", " + name + "!";
    }
}
