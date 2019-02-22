package com.student.dogs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration

public class SeedDatabase {
    public CommandLineRunner initDB(DogRepository dogRepo){
        return args -> {
            log.info("Seeding " + dogRepo.save(new Dogs("Springer", 50, false)));
            log.info("Seeding " + dogRepo.save(new Dogs("Bulldog", 50, true)));
            log.info("Seeding " + dogRepo.save(new Dogs("Collie", 50, false)));
            log.info("Seeding " + dogRepo.save(new Dogs("Boston Terrie", 35, true)));
            log.info("Seeding " + dogRepo.save(new Dogs("Corgi", 35, true)));
        };
    }
}
