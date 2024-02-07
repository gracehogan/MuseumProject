package com.barclays.controller;

import com.barclays.model.Artist;
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
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
@SuppressWarnings("java:S3577")
class ArtistTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();
    ResultActions resultActions;


    @Test
    void testGetAllArtists() throws Exception {
        int expectedLength = 19;

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        Artist[] artists = mapper.readValue(contentAsString, Artist[].class);

        assertEquals(expectedLength, artists.length);
    }

    @Test
    void testGetArtistById() throws Exception {
        int id = 1;

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        Artist artist = mapper.readValue(contentAsString, Artist.class);

        assertEquals("Leonardo Da Vinci", artist.getName());
        assertEquals(id, artist.getId());
    }


}
