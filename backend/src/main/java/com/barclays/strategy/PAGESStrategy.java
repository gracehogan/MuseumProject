package com.barclays.strategy;

import com.barclays.dto.BookingDTO;

public class PAGESStrategy implements BookingStrategy {



    @Override
    public double calculateFee(BookingDTO bookingDTO) {
        return estimateFee(bookingDTO,100);
    }

     static double estimateFee(BookingDTO bookingDTO,double flatFee) {
        return (bookingDTO.getNumberOfPersons() < 5) ?
                switch (bookingDTO.getBookingType()) {
                    case SINGLE_ADULT, SINGLE_CHILD -> getFee(bookingDTO, flatFee);
                    default -> 0;
                } :
                switch (bookingDTO.getBookingType()) {
                    case GROUP_ADULT, GROUP_CHILD -> getFee(bookingDTO, flatFee);
                    default -> 0;
                };
    }

    private static double getFee(BookingDTO bookingDTO, double flatFee) {
        return bookingDTO.getNumberOfPersons() * bookingDTO.getBookingType().getDiscount() * flatFee;
    }


}
