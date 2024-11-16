package com.example.demo.seeders;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Slf4j
@Profile("local")
public abstract class Seeder implements CommandLineRunner {

    private final String SEED_NAME = this.getClass().getSimpleName().toLowerCase();

    @Override
    final public void run(String... args) {
        log.info("Seeding {} ...", SEED_NAME);
        Date start = new Date();
        seeding(); // The process of seeding is delegated to the concrete class
        Date end = new Date();
        log.info("Successfully seeded {}", SEED_NAME);
        log.info("{} have been seeded in {} ms", SEED_NAME, (end.getTime() - start.getTime()));
    }

    protected abstract void seeding();
}
