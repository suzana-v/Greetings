package com.svulinovic.greetings.component;

import com.svulinovic.greetings.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalTime;

@Component
@ConditionalOnProperty(
        name = "greeter",
        havingValue = "good"
)
public class GoodGreeter implements Greeter {

    private final Clock clock;

    public GoodGreeter(Clock clock) {
        this.clock = clock;
    }

    @Override
    public String greet(String name) {
        LocalTime now = LocalTime.now(clock);

        String greeting;
        if (now.isAfter(LocalTime.of(19, 59))) {
            greeting = "Good night";
        } else if (now.isAfter(LocalTime.of(16,59))) {
            greeting = "Good evening";
        } else if (now.isAfter(LocalTime.of(11,59))) {
            greeting = "Good afternoon";
        } else if (now.isAfter(LocalTime.of(2,59))) {
            greeting = "Good morning";
        } else {
            greeting = "Good night"; //from 00:00 to 02:59
        }
        return greeting + ", " + name + "!";
    }

}
