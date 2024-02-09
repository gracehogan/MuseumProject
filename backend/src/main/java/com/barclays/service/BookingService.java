package com.barclays.service;

import com.barclays.dto.BookingDTO;
import com.barclays.model.Booking;

public interface BookingService {

    Booking findById(Long id);
    Booking save(BookingDTO bookingDTO);

    double calculateFee(BookingDTO bookingDTO);

    double setFeeOfBooking(BookingDTO bookingDTO);

    void deleteById(Long id);
}


