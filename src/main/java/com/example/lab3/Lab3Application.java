package com.example.lab3;

//Ajakaye Oluwatosin
//101210057

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab3Application {

    private static final Logger log = LoggerFactory.getLogger(Lab3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository) {
        return (args) -> {
            log.info("Starting Address Book Application...");

            // Create and populate address book
            AddressBook addressBook = new AddressBook();
            addressBook.addBuddy(new BuddyInfo("Luke", "123 Tatooine Ave", "555-1234"));
            addressBook.addBuddy(new BuddyInfo("Leia", "456 Alderaan St", "555-5678"));
            addressBook.addBuddy(new BuddyInfo("Han", "789 Millennium Falcon", "555-9012"));

            // Save to database
            repository.save(addressBook);
            log.info("Saved address book with {} buddies", addressBook.getBuddies().size());

            // Display results
            log.info("\n" + "=".repeat(50));
            log.info("ADDRESS BOOK CONTENTS");
            log.info("=".repeat(50));

            repository.findAll().forEach(book -> {
                log.info("Address Book ID: {}", book.getId());
                book.getBuddies().forEach(buddy ->
                        log.info("  - {} | {} | {}", buddy.getName(), buddy.getPhoneNumber(), buddy.getAddress())
                );
            });

            log.info("=".repeat(50));
        };
    }
}