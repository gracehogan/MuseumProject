//package com.barclays.controller;
//
//
//import com.barclays.model.Museum;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.flywaydb.core.Flyway;
//import org.junit.jupiter.api.BeforeEach;
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
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(properties = "spring.flyway.clean-disabled=false")
//@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@TestPropertySource(properties = {"spring.sql.init.mode=never"})
//@SuppressWarnings("java:S3577")
//class MuseumTestsWithMockHttpRequest {
//    ResultActions resultActions;
//    ObjectMapper mapper = new ObjectMapper();
//    @Autowired
//    MockMvc mockMvc;
//
////Clear Database
//    @BeforeEach
//    void clearDatabase(@Autowired Flyway flyway) {
//        flyway.clean();
//        flyway.migrate();
//    }
////Dummy Data
//    String json = """
//            {
//            \t\t"name": "London MUSE",
//            \t\t"location": "London",
//            \t\t"curator": "Bob",
//            \t\t"artworkList": [
//            \t\t\t{
//            \t\t\t\t"name": "Pelumi the Princess",
//            \t\t\t\t"yearCompleted": 2022,
//            \t\t\t\t"medium": "MARBLE",
//            \t\t\t\t"backstory": "None",
//            \t\t\t\t"artworkType": "SCULPTURE"
//            \t\t\t},
//            \t\t\t{
//            \t\t\t\t"name": "Shona the Surfer",
//            \t\t\t\t"yearCompleted": 2015,
//            \t\t\t\t"medium": "WATERCOLOUR",
//            \t\t\t\t"backstory": "None",
//            \t\t\t\t"artworkType": "PAINTING"
//            \t\t\t}
//            \t\t]
//            \t}""";
//
//
//    String json1 = """
//            {
//            \t\t"id": 3,
//            \t\t"name": "Galeria",
//            \t\t"location": "Coventry",
//            \t\t"curator": "Jim",
//            \t\t"artworkList": [
//            \t\t\t{
//            \t\t\t\t"name": "Barbara Liskov",
//            \t\t\t\t"yearCompleted": 2013,
//            \t\t\t\t"medium": "BRONZE",
//            \t\t\t\t"backstory": "Genius",
//            \t\t\t\t"artworkType": "SCULPTURE"
//            \t\t\t},
//            \t\t\t{
//            \t\t\t\t"name": "Alan Turing",
//            \t\t\t\t"yearCompleted": 1952,
//            \t\t\t\t"medium": "OIL",
//            \t\t\t\t"backstory": "None",
//            \t\t\t\t"artworkType": "PAINTING"
//            \t\t\t}
//            \t\t]
//            \t}""";
//
//    //MockMVCRequestBuilders Methods
//    private String getContent(String url) throws Exception {
//        ResultActions actions = this.mockMvc.perform(MockMvcRequestBuilders.get(url)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//        MvcResult result = actions.andReturn();
//        return result.getResponse().getContentAsString();
//    }
//
//    private String postContent(String url) throws Exception {
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post(url)
//                        .content(json)
//                        .contentType(APPLICATION_JSON)
//                        .accept(APPLICATION_JSON))
//                .andExpect(status().isOk());
//        MvcResult result = resultActions.andReturn();
//        return result.getResponse().getContentAsString();
//    }
//
//    private String putContent(String url) throws Exception {
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.put(url)
//                        .content(json1)
//                        .contentType(APPLICATION_JSON)
//                        .accept(APPLICATION_JSON))
//                .andExpect(status().isOk());
//        MvcResult result = resultActions.andReturn();
//        return result.getResponse().getContentAsString();
//    }
//
//    private void deleteContent(String url) throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.delete(url)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//
//    //Test Methods
//    @Test
//    void testGettingAllMuseums() throws Exception {
//        String url = "/museums";
//        String content = getContent(url);
//        Museum[] museums = mapper.readValue(content, Museum[].class);
//        assertAll("Testing from a data.sql file",
//                () -> assertEquals(3, museums.length),
//                () -> assertEquals("PEGS", museums[0].getName())
//        );
//    }
//
//    @Test
//    void testGettingMuseumById() throws Exception {
//        int id = 1;
//        String url = "/museums/";
//        String content = getContent(url + id);
//        Museum museums = mapper.readValue(content, Museum.class);
//        assertAll("Testing from a data.sql file",
//                () -> assertEquals("Northampton", museums.getLocation()),
//                () -> assertEquals(2, museums.getArtworkList().size())
//        );
//    }
//
//    @Test
//    void testGetMuseumLocation() throws Exception {
//        String name = "Alan Turing";
//        String url = "/museums/art-location?name=";
//        String content = getContent(url + name);
//        assertEquals("The Location of Alan Turing is Coventry", content);
//    }
//
//    @Test
//    void testWithMostCombinedWorksByArtistByName() throws Exception {
//        String name = "Bob";
//        String url = "/museums/most-works-museum?name=";
//        String content = getContent(url + name);
//        assertEquals("The museum with the most works by Bob is PEGS", content);
//    }
//
//    @Test
//    void testGetMuseumWithMostArtByArtist() throws Exception {
//        int id = 3;
//        String url = "/museums/most-artwork/";
//        String content = getContent(url + id);
//        Museum museum = mapper.readValue(content, Museum.class);
//        assertEquals("Galeria", museum.getName());
//    }
//
//    @Test
//    void testSaveMuseum() throws Exception {
//        String url = "/museums";
//        String content = postContent(url);
//        Museum museum = mapper.readValue(content, Museum.class);
//        assertEquals("London MUSE", museum.getName());
//        deleteContent("/museums/" + museum.getId());
//    }
//
//    @Test
//    void testUpdateMuseum() throws Exception {
//        String url = "/museums";
//        String content = putContent(url);
//        Museum museum = mapper.readValue(content, Museum.class);
//        assertEquals("Galeria", museum.getName());
//    }
//
//    @Test
//    void testDeleteMuseumById() throws Exception {
//        int id = 1000;
//        String url = "/museums/";
//        deleteContent(url + id);
//    }
//
//
//}
//
