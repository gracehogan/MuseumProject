//package com.barclays.controller;
//
//import com.barclays.model.Artist;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//@TestPropertySource(properties = {"spring.sql.init.mode=never"})
//@SuppressWarnings("java:S3577")
//class ArtistTestsWithMockHttpRequest {
//
//    @Autowired
//    MockMvc mockMvc;
//    ObjectMapper mapper = new ObjectMapper();
//    ResultActions resultActions;
//
//
//    @Test
//    void testGetAllArtists() throws Exception {
//        int expectedLength = 3;
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artists")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//        Artist[] artists = mapper.readValue(contentAsString, Artist[].class);
//
//        assertEquals(expectedLength, artists.length);
//    }
//
//    @Test
//    void testGetArtistById() throws Exception {
//        int id = 1;
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/" + id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Artist artist = mapper.readValue(contentAsString, Artist.class);
//
//        assertEquals("Bob", artist.getName());
//        assertEquals(id, artist.getId());
//    }
//
//
//    @Test
//    void testCreateArtist() throws Exception {
//        Artist artist = new Artist();
//        artist.setName("John");
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/artist")
//                        .content(mapper.writeValueAsString(artist))
//                        .contentType(APPLICATION_JSON)
//                        .accept(APPLICATION_JSON))
//                        .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        artist = mapper.readValue(contentAsString, Artist.class);
//
//        assertEquals("John", artist.getName());
//
//        this.mockMvc.perform(MockMvcRequestBuilders.delete("/artist/" + artist.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//
//    @Test
//    void testDeleteArtist() throws Exception {
//        int id = 1000;
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/artist/" + id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        assertEquals("", contentAsString);
//    }
//
//
//    @Test
//    void testUpdateArtist() throws Exception {
//
//        String json = "{\n" +
//                "        \"id\": 3,\n" +
//                "        \"name\": \"Billy\",\n" +
//                "        \"yearOfBirth\": 1933,\n" +
//                "        \"yearOfDeath\": 4023,\n" +
//                "        \"artworkList\": []\n" +
//                "    }";
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put("/artists")
//                        .content(json)
//                        .contentType(APPLICATION_JSON)
//                        .accept(APPLICATION_JSON))
//                .andExpect(status().isOk());
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//        Artist artist = mapper.readValue(contentAsString, Artist.class);
//        assertEquals("Billy", artist.getName());
//    }
//
//
//    @Test
//    void testSortByMostPaintings() throws Exception {
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/most-paintings")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Artist[] artist = mapper.readValue(contentAsString, Artist[].class);
//
//        assertEquals("Bob", artist[0].getName());
//    }
//}
