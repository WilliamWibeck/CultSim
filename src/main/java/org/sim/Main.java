package org.sim;

import org.axonframework.eventhandling.EventBus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final EventBus eventBus;

    public Main(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        List<Cult> cults = new ArrayList<>();

        cults.add(new Cult("1", "Scienthology", 902, eventBus));
        cults.add(new Cult("2", "Church of Fiery Skies", 524, eventBus));
        cults.add(new Cult("3", "Doomsday Believers", 209, eventBus));
        cults.add(new Cult("4", "The Scarlet Crusade", 2012, eventBus));

        for (int i = 1; i <= 10; i++) {
            System.out.println("\n Turn: " + "[" + i + "]");
            cults.forEach(Cult::recruitFollowers);
        }
    }
}