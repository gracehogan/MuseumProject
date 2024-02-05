//package com.barclays.controller;
//
//import com.barclays.model.Sculpture;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
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
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest(properties = "spring.flyway.clean-disabled=false")
//@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//@TestPropertySource(properties = {"spring.sql.init.mode=never"})
//@SuppressWarnings("java:S3577")
//class SculptureTestsWithMockHttpRequest {
//
//    @Autowired
//    MockMvc mockMvc;
//    ObjectMapper mapper = new ObjectMapper();
//    ResultActions resultActions;
//
//
//    @BeforeEach
//    void clearDatabase(@Autowired Flyway flyway) {
//        flyway.clean();
//        flyway.migrate();
//    }
//    @Test
//    void testGettingAllSculptures() throws Exception {
//        int expectedLength = 3;
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/sculptures")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Sculpture[] sculptures = mapper.readValue(contentAsString, Sculpture[].class);
//
//        assertAll(
//                () -> assertEquals(expectedLength, sculptures.length),
//                () -> assertEquals("Eddy The Emperor", sculptures[0].getName())
//        );
//    }
//
//    @Test
//    void testGettingSculptureById() throws Exception {
//        int id = 1;
//
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/sculptures/{id}", id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Sculpture sculpture = mapper.readValue(contentAsString, Sculpture.class);
//
//        assertEquals("Eddy The Emperor", sculpture.getName());
//    }
//
//    @Test
//    void testCreateSculpture() throws Exception {
//        Sculpture sculpture = new Sculpture();
//        sculpture.setName("Test Sculpture");
//
//        mapper = new ObjectMapper();
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/sculptures")
//                        .content(mapper.writeValueAsString(sculpture))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        sculpture = mapper.readValue(contentAsString, Sculpture.class);
//
//        assertEquals("Test Sculpture", sculpture.getName());
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/sculptures/" + sculpture.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testDeleteSculpture() throws Exception {
//        int id = 1000;
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/sculptures/" + id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        assertEquals("", contentAsString);
//    }
//
//    @Test
//    void testUpdateSculpture() throws Exception {
//
//        Sculpture sculpture = new Sculpture();
//        sculpture.setName("Test Sculpture");
//
//        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/sculptures")
//                        .content(mapper.writeValueAsString(sculpture))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Sculpture updatedSculpture = mapper.readValue(contentAsString, Sculpture.class);
//        updatedSculpture.setName("Updated Sculpture");
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/sculptures", updatedSculpture.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(updatedSculpture));
//
//        mockMvc.perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Updated Sculpture"));
//
//        this.mockMvc.perform(MockMvcRequestBuilders.delete("/sculptures/" + updatedSculpture.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testGetAllSculpturesByArtistAndMuseum() throws Exception {
//        Long artistId = 2L;
//        Long museumId = 2L;
//        int expectedLength = 1;
//
//        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/sculptures/{artistId}/{museumId}", artistId, museumId)
//                         .contentType(MediaType.APPLICATION_JSON)
//                         .accept(MediaType.APPLICATION_JSON))
//                         .andExpect(status().isOk());
//
//        MvcResult result = resultActions.andReturn();
//        String contentAsString = result.getResponse().getContentAsString();
//
//        Sculpture[] sculpture = mapper.readValue(contentAsString, Sculpture[].class);
//
//        assertEquals(expectedLength, sculpture.length);
//    }
//}