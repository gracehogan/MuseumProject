//package com.barclays.controller;
//
//import com.barclays.model.Painting;
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
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(properties = "spring.flyway.clean-disabled=false")
//@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//@TestPropertySource(properties = {"spring.sql.init.mode=never"})
//@SuppressWarnings("java:S3577")
//class PaintingTestsWithMockHttpRequest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @BeforeEach
//    void clearDatabase(@Autowired Flyway flyway) {
//        flyway.clean();
//        flyway.migrate();
//    }
//    @Test
//    void testGetPaintings() throws Exception {
//        int expectedLength = 3;
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/paintings")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//        Painting[] paintings = mapper.readValue(contentAsString, Painting[].class);
//
//        assertEquals(expectedLength, paintings.length);
//
//    }
//
//    @Test
//    void testGetPainting() throws Exception {
//
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/paintings/2")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Painting painting = mapper.readValue(contentAsString, Painting.class);
//
//        assertAll("Mock Http Request Testing GET",
//                () -> assertEquals("Shona Lisa", painting.getName()),
//                () -> assertEquals(2, painting.getId())
//        );
//
//
//    }
//
//    @Test
//    void testCreatePainting() throws Exception {
//        Painting painting = new Painting();
//        painting.setName("Starry Night");
//
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/paintings")
//                        .content(mapper.writeValueAsString(painting))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        painting = mapper.readValue(contentAsString, Painting.class);
//
//        assertEquals("Starry Night", painting.getName());
//
//        this.mockMvc.perform(MockMvcRequestBuilders.delete("/paintings/" + painting.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testDeletePainting() throws Exception {
//        int id = 1000;
//                        this.mockMvc.perform(MockMvcRequestBuilders.delete("/paintings/" + id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testUpdatePainting() throws Exception {
//
//        Painting painting = new Painting();
//        painting.setName("Daffodils");
//
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/paintings")
//                        .content(mapper.writeValueAsString(painting))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Painting updatedPainting = mapper.readValue(contentAsString, Painting.class);
//
//        updatedPainting.setName("Sunflowers");
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/paintings", updatedPainting.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(updatedPainting));
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Sunflowers"));
//
//        this.mockMvc.perform(MockMvcRequestBuilders.delete("/paintings/" + updatedPainting.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    void testFindLastPaintingByArtist() throws Exception {
//        int id = 1;
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/" + id + "/last-painting")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Painting painting = mapper.readValue(contentAsString, Painting.class);
//
//        assertEquals(2023, painting.getYearCompleted());
//    }
//
//    @Test
//    void testFindFirstPaintingByArtist() throws Exception {
//        int id = 1;
//
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/" + id + "/first-painting")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Painting painting = mapper.readValue(contentAsString, Painting.class);
//
//        assertEquals(2015, painting.getYearCompleted());
//    }
//}
