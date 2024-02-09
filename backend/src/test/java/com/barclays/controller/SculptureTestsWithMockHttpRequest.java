package com.barclays.controller;

import com.barclays.dto.SculptureDTO;
import com.barclays.model.Sculpture;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@SuppressWarnings("java:S3577")
class SculptureTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();
    ResultActions resultActions;


    @Test
    void testGettingAllSculptures() throws Exception {
        int expectedLength = 11;

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/sculptures")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        SculptureDTO[] sculptures = mapper.readValue(contentAsString, SculptureDTO[].class);

        assertEquals(expectedLength, sculptures.length);

    }

    @Test
    void testGettingSculptureById() throws Exception {
        int id = 1;

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/sculptures/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        SculptureDTO sculpture = mapper.readValue(contentAsString, SculptureDTO.class);

        assertEquals("David", sculpture.getTitle());
    }
}