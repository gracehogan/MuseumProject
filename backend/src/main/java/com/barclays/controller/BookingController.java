package com.barclays.controller;

import com.barclays.dto.BookingDTO;
import com.barclays.model.Booking;
import com.barclays.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/saveBooking/{name}/{numberOfPersons}/{bookingType}/{email}/{bookedMuseum}")
    public Booking saveBooking(@PathVariable String name,@PathVariable int numberOfPersons,@PathVariable  String bookingType,
                                     @PathVariable  String email,@PathVariable  String bookedMuseum) {
        BookingDTO bookingDTO = bookingService.createBookingDTO(name,numberOfPersons, bookingType, email, bookedMuseum);
        return bookingService.save(bookingDTO);
    }


    @PostMapping("/estimateFee/{name}/{numberOfPersons}/{bookingType}/{email}/{bookedMuseum}")
    public String estimateBookingFee(@PathVariable String name,@PathVariable int numberOfPersons,@PathVariable  String bookingType,
                                     @PathVariable  String email,@PathVariable  String bookedMuseum) {
        BookingDTO bookingDTO = bookingService.createBookingDTO(name,numberOfPersons, bookingType, email, bookedMuseum);
        return bookingService.setFeeOfBooking(bookingDTO);
    }


}

