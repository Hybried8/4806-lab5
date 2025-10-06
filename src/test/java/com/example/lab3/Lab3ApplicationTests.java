package com.example.lab3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Lab3ApplicationTests {

    @Autowired
    private BuddyController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
