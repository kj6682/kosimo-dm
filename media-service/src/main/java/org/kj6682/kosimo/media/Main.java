package org.kj6682.kosimo.media;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication(scanBasePackages = "org.kj6682.kosimo.*")
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    static class MediaNotFoundException extends RuntimeException {
        MediaNotFoundException(String id) {
            super("could not find media for '" + id + "'.");
        }

    }//:)

    @Bean
    @Profile("dev")
    public CommandLineRunner demo(MediaRepository repository) {
        return (evt) -> {
            repository.save(new Media("Franz Kafka", "Der Prozess", Media.Type.BOOK, "The Red Room:Case A:Shelf 1"));
            repository.save(new Media("George Orwell", "1984", Media.Type.BOOK, "The Red Room:Case A:Shelf 2"));
            repository.save(new Media("Dreamworks", "Rise of Guardians", Media.Type.MOVIE, "The Red Room:Case B:Shelf 1"));
        };
    }//:)

}//:)

