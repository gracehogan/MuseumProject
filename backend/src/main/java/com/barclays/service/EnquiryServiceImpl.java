package com.barclays.service;

import com.barclays.dto.BookingDTO;
import com.barclays.dto.EnquiryDTO;
import com.barclays.exception.InvalidBookingException;
import com.barclays.model.Booking;
import com.barclays.model.Enquiry;
import com.barclays.model.enums.BookedMuseum;
import com.barclays.model.enums.BookingType;
import com.barclays.repository.EnquiryRepository;
import com.barclays.strategy.BookingStrategy;
import com.barclays.strategy.BookingStrategyFactory;
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
    public Enquiry Save(EnquiryDTO enquiryDTO) {
        Enquiry enquiry = new Enquiry();
        enquiry.setName(enquiryDTO.getName());
        enquiry.setEmail(enquiryDTO.getEmail());
        enquiry.setName(enquiryDTO.getName());
        enquiry.setEnquiryDate(enquiryDTO.getEnquiryDate());
        enquiry.setEnquiryType(enquiryDTO.getEnquiryType());
//        if (checkValidEmail(enquiry.getEmail())) {
            return enquiryRepository.save(enquiry);
//        } else throw new InvalidBookingException("invalid email");
    }


    @Override
    public EnquiryDTO createEnquiryDTO(String name, String email, String enquiryType, String enquiryText, String enquiryDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        EnquiryDTO bookingDTO = new EnquiryDTO();
        bookingDTO.setEmail(email);
        bookingDTO.setName(name);
        bookingDTO.setEnquiryType(enquiryType);
        bookingDTO.setEnquiryText(enquiryText);
        bookingDTO.setEnquiryDate(LocalDateTime.parse(enquiryDate, formatter));
        return bookingDTO;
    }

    public Boolean checkValidEmail(String email) {
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        return pattern.matcher(email).matches();
    }


}

