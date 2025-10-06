package com.example.lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.lang.reflect.Array.get;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Lab3Applicationest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void hasBuddies() throws Exception {
        String response = restTemplate.getForObject("http://localhost:" + port + "/buddies", String.class);

        assertThat(response).isNotNull();

        // Parse the JSON into a list (requires Jackson)
        ObjectMapper mapper = new ObjectMapper();
        List<?> buddies = mapper.readValue(response, List.class);

        // Check that there are at least 2 buddies
        assertThat(buddies.size()).isGreaterThanOrEqualTo(2);
    }



}