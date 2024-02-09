package com.barclays.service;

import com.barclays.dto.EnquiryDTO;
import com.barclays.model.Enquiry;

public interface EnquiryService {

    Enquiry findById(Long id);
    Enquiry save(EnquiryDTO enquiryDTO);


    void deleteById(Long id);
}
