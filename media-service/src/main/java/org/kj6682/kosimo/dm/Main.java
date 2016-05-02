package org.kj6682.kosimo.dm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(MediaRepository repository) {
        return (evt) -> {
            repository.save(new Media("Franz Kafka", "Der Prozess", Media.Type.BOOK, "The Red Room:Case A:Shelf 1"));
        };
    }

    static class MediaNotFoundException extends RuntimeException {
        MediaNotFoundException(String id) {
            super("could not find media '" + id + "'.");
        }

    }//:)

}

