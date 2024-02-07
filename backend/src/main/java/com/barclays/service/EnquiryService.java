package com.barclays.service;

import com.barclays.dto.EnquiryDTO;
import com.barclays.model.Enquiry;

public interface EnquiryService {

    Enquiry findById(Long id);
    Enquiry save(EnquiryDTO enquiryDTO);
    EnquiryDTO createEnquiryDTO(String name, String email, String enquiryType, String enquiryText);

}

//name
//email
//enquiryType
//enquiryText
//enquiryDate
