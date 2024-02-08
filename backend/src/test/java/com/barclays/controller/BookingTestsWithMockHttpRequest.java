package com.barclays.controller;

import com.barclays.model.Artist;
import com.barclays.model.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
//@SuppressWarnings("java:S3577")
class BookingTestsWithMockHttpRequest {

    @Autowired
    MockMvc mockMvc;
    ResultActions resultActions;
    Booking booking;
    ObjectMapper mapper;


    @Test
    void testCreateBooking() throws Exception {
        booking = new Booking();
        mapper = new ObjectMapper();
        String url="/saveBooking/eddy/4/SINGLE_ADULT/abc@gmail.com/PAGES/7th Sept 24 8pm";
        mapper.registerModule(new JavaTimeModule());
        String contentAsString = getContentAsString(mapper, booking,url);
        booking = mapper.readValue(contentAsString, Booking.class);
        assertEquals("eddy", booking.getName());
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/deleteBooking/" + booking.getId())
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String getContentAsString(ObjectMapper mapper, Booking booking,String url) throws Exception {
        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .content(mapper.writeValueAsString(booking))
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        return contentAsString;
    }

    @Test
    void testCalculateBookingFee() throws Exception {
        booking = new Booking();
        mapper = new ObjectMapper();
        String url="/estimateFee/eddy/4/SINGLE_ADULT/abc@gmail.com/PAGES/7th Sept 24 8pm";
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        assertEquals(400, Double.parseDouble(contentAsString));
    }
}
