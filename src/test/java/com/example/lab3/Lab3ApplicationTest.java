package com.example.lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Lab3ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hasBuddies() throws Exception {
        // Perform GET request to /buddies
        String response = mockMvc.perform(get("/buddies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        // Parse JSON response into a list
        ObjectMapper mapper = new ObjectMapper();
        List<?> buddies = mapper.readValue(response, List.class);

        // Assertions
        assertThat(buddies).isNotNull();
        assertThat(buddies.size()).isGreaterThanOrEqualTo(2);
    }
}
