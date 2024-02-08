package com.barclays.service;

import com.barclays.dto.EnquiryDTO;
import com.barclays.model.Enquiry;
import com.barclays.repository.EnquiryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {

    private EnquiryRepository enquiryRepository;
//name
    //email
    //enquiryType
    //enquiryType
    //date

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
        enquiry.setEnquiryText(enquiryDTO.getEnquiryText());
        enquiry.setEnquiryDate(enquiryDTO.getEnquiryDate());
        enquiry.setEnquiryType(enquiryDTO.getEnquiryType());
            return enquiryRepository.save(enquiry);
    }


    @Override
    public EnquiryDTO createEnquiryDTO(String name, String email, String enquiryType, String enquiryText) {
        EnquiryDTO enquiryDTO = new EnquiryDTO();
        enquiryDTO.setName(name);
        enquiryDTO.setEmail(email);
        enquiryDTO.setEnquiryType(enquiryType);
        enquiryDTO.setEnquiryText(enquiryText);
        enquiryDTO.setEnquiryDate(LocalDateTime.now());
        return enquiryDTO;
    }

    @Override
    public void deleteById(Long id) {
        enquiryRepository.deleteById(id);
    }

    public Boolean checkValidEmail(String email) {
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        return pattern.matcher(email).matches();
    }


}

