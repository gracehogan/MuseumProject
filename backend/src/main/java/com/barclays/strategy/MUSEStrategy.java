package com.barclays.strategy;

import com.barclays.dto.BookingDTO;
import com.barclays.model.enums.BookingType;

import static com.barclays.strategy.PAGESStrategy.estimateFee;

public class MUSEStrategy implements BookingStrategy {


    @Override
    public double calculateFee(BookingDTO bookingDTO) {
        return estimateFee(bookingDTO,200);
    }
}
