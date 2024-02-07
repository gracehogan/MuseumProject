package com.barclays.strategy;

import com.barclays.dto.BookingDTO;
import com.barclays.model.enums.BookingType;

public interface BookingStrategy {
    double calculateFee(BookingDTO bookingDTO);
}
