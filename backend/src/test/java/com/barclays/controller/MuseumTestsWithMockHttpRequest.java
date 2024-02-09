package com.barclays.controller;


import com.barclays.dto.MuseumDTO;
import com.barclays.model.Museum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@SuppressWarnings("java:S3577")
class MuseumTestsWithMockHttpRequest {

    ResultActions resultActions;
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetAllMuseums() throws Exception {
        int expectedLength = 4;

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/museums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        MuseumDTO[] museums = mapper.readValue(contentAsString, MuseumDTO[].class);

        assertEquals(expectedLength, museums.length);
    }

    @Test
    void testGetMuseumById() throws Exception {
        int id = 1;

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/museums/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        MuseumDTO museum = mapper.readValue(contentAsString, MuseumDTO.class);

        assertEquals("PAGES", museum.getName());
        assertEquals(id, museum.getId());
    }
}

