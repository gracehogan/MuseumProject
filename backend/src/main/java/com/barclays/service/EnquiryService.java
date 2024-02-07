package com.barclays.service;

import com.barclays.dto.BookingDTO;
import com.barclays.dto.EnquiryDTO;
import com.barclays.model.Booking;
import com.barclays.model.Enquiry;

public interface EnquiryService {

    Enquiry findById(Long id);
    Enquiry Save(EnquiryDTO enquiryDTO);
    EnquiryDTO createEnquiryDTO(String name, String email, String enquiryType, String enquiryText, String enquiryDate);

}

//name
//email
//enquiryType
//enquiryText
//enquiryDate
