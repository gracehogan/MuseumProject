package com.barclays.service;

import com.barclays.dto.BookingDTO;
import com.barclays.model.Artist;
import com.barclays.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    Booking findById(Long id);
    Booking Save(BookingDTO bookingDTO);

    double calculateFee(BookingDTO bookingDTO);
    BookingDTO createBookingDTO(String name,int number, String bookingType, String email, String bookedMuseum, String bookingDate);

}

