package com.barclays.controller;

import com.barclays.dto.PaintingDTO;
import com.barclays.model.Painting;
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

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@SuppressWarnings("java:S3577")
class PaintingTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void testGetPaintings() throws Exception {
        int expectedLength = 13;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/paintings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        PaintingDTO[] paintings = mapper.readValue(contentAsString, PaintingDTO[].class);

        assertEquals(expectedLength, paintings.length);

    }

    @Test
    void testGetPainting() throws Exception {

        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/paintings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        PaintingDTO painting = mapper.readValue(contentAsString, PaintingDTO.class);

        assertAll("Mock Http Request Testing GET",
                () -> assertEquals("Shona Lisa", painting.getTitle()),
                () -> assertEquals(1, painting.getId())
        );
    }
}
