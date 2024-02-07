package com.barclays.controller;

import com.barclays.dto.EnquiryDTO;
import com.barclays.model.Enquiry;
import com.barclays.service.EnquiryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class EnquiryController {

    private final EnquiryService enquiryService;

    @PostMapping("/sendEnquiry/{name}/{email}/{enquiryType}/{enquiryText}")
    public String saveCustomerEnquiry(@PathVariable String name, @PathVariable String email,
                                       @PathVariable String enquiryType, @PathVariable String enquiryText) {
        EnquiryDTO enquiryDTO = enquiryService.createEnquiryDTO(name, enquiryType, email, enquiryText);
         enquiryService.save(enquiryDTO);
         return "Enquiry Sent";

    }
}

//name
//email
//enquiryType
//enquiryText
//date
