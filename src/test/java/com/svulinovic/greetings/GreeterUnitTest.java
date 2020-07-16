package com.svulinovic.greetings;

import com.svulinovic.greetings.config.AppConfig;
import com.svulinovic.greetings.component.DefaultGreeter;
import com.svulinovic.greetings.component.GoodGreeter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GreeterUnitTest {

    @Autowired
    private AppConfig appConfig;

    @Test
    public void testDefaultGreeter() {
        var greeter = new DefaultGreeter(appConfig);
        assertEquals(appConfig.getGreeting().getGreeting() + ", Suzana!", greeter.greet("Suzana"));
    }

    @Test
    public void testGoodGreeter() {
        var morning = Clock.fixed(Instant.from(LocalDate.now().atTime(3, 0).atZone(ZoneId.systemDefault())), ZoneId.systemDefault());
        var afternoon = Clock.fixed(Instant.from(LocalDate.now().atTime(12, 0).atZone(ZoneId.systemDefault())), ZoneId.systemDefault());
        var evening = Clock.fixed(Instant.from(LocalDate.now().atTime(17, 0).atZone(ZoneId.systemDefault())), ZoneId.systemDefault());
        var night = Clock.fixed(Instant.from(LocalDate.now().atTime(20, 0).atZone(ZoneId.systemDefault())), ZoneId.systemDefault());
        var night2 = Clock.fixed(Instant.from(LocalDate.now().atTime(0, 0).atZone(ZoneId.systemDefault())), ZoneId.systemDefault());

        var morningGreeter = new GoodGreeter(morning);
        assertEquals("Good morning, Suzana!", morningGreeter.greet("Suzana"));

        var afternoonGreeter = new GoodGreeter(afternoon);
        assertEquals("Good afternoon, Suzana!", afternoonGreeter.greet("Suzana"));

        var eveningGreeter = new GoodGreeter(evening);
        assertEquals("Good evening, Suzana!", eveningGreeter.greet("Suzana"));

        var nightGreeter = new GoodGreeter(night);
        assertEquals("Good night, Suzana!", nightGreeter.greet("Suzana"));

        var night2Greeter = new GoodGreeter(night2);
        assertEquals("Good night, Suzana!", night2Greeter.greet("Suzana"));
    }

}
