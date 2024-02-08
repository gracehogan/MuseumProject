package com.barclays.controller;

import com.barclays.model.Enquiry;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class EnquiryTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ResultActions resultActions;

    Enquiry enquiry;
    ObjectMapper mapper;


    @Test
    void testCreateEnquiry() throws Exception {
        enquiry= new Enquiry();
        mapper = new ObjectMapper();
        String url="/sendEnquiry/edy/edy@gmail.com/Ticket-Enquiry/How much are single adult tickets?";
        mapper.registerModule(new JavaTimeModule());
        String contentAsString = getContentAsString(mapper, enquiry,url);
        enquiry = mapper.readValue(contentAsString, Enquiry.class);
        assertEquals("edy", enquiry.getName());
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEnquiry/" + enquiry.getId())
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    private String getContentAsString(ObjectMapper mapper, Enquiry enquiry,String url) throws Exception {
        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .content(mapper.writeValueAsString(enquiry))
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        return contentAsString;
    }



}
