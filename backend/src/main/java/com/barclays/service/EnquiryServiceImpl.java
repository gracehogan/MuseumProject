package com.barclays.service;

import com.barclays.dto.EnquiryDTO;
import com.barclays.model.Enquiry;
import com.barclays.repository.EnquiryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Pattern;
@Service
@AllArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {
    private EnquiryRepository enquiryRepository;


    @Override
    public Enquiry findById(Long id) {
        Optional<Enquiry> enquiry = enquiryRepository.findById(id);
        return enquiry.orElseGet(Enquiry::new);
    }

    @Override
    public Enquiry save(EnquiryDTO enquiryDTO) {
        Enquiry enquiry = new Enquiry();
        enquiry.setName(enquiryDTO.getName());
        enquiry.setEmail(enquiryDTO.getEmail());
        enquiry.setEnquiry(enquiryDTO.getEnquiry());
        enquiry.setEnquiryDate(enquiryDTO.getEnquiryDate());
        enquiry.setEnquiryDate(LocalDateTime.now());
        return enquiryRepository.save(enquiry);
    }

    @Override
    public void deleteById(Long id) {
        enquiryRepository.deleteById(id);
    }

}
