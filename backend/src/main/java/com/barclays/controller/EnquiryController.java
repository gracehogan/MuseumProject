package com.barclays.controller;

import com.barclays.dto.BookingDTO;
import com.barclays.dto.EnquiryDTO;
import com.barclays.model.Booking;
import com.barclays.model.Enquiry;
import com.barclays.service.EnquiryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class EnquiryController {

    private final EnquiryService enquiryService;


    @PostMapping("/saveEnquiry")
    public Enquiry saveNewEnquiry(@RequestBody EnquiryDTO enquiryDTO) {
        return enquiryService.save(enquiryDTO);
    }

    @DeleteMapping("/deleteEnquiry/{id}")
    public void deleteEnquiryById(@PathVariable Long id) {
        log.debug("deleteEnquiryById method logged");
        enquiryService.deleteById(id);
    }
}