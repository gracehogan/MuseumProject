package com.barclays.strategy;

import com.barclays.dto.BookingDTO;

public class BookingStrategyFactory {

    public  static BookingStrategy getBookingStrategy(BookingDTO bookingDTO){
        BookingStrategy bookingStrategy;
        switch (bookingDTO.getBookedMuseum()) {
            case MUSE -> {bookingStrategy=new MUSEStrategy();}
            default -> {
                bookingStrategy=new PAGESStrategy();}
        }
        return bookingStrategy;
    }

}
