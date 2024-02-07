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

    @PostMapping("/estimateFee/{name}/{numberOfPersons}/{bookingType}/{email}/{bookedMuseum}/{bookingDate}")
    public String estimateBookingFee(@PathVariable String name,@PathVariable int numberOfPersons,@PathVariable  String bookingType,
                                     @PathVariable  String email,@PathVariable  String bookedMuseum,@PathVariable  String bookingDate) {
        BookingDTO bookingDTO = bookingService.createBookingDTO(name,numberOfPersons, bookingType, email, bookedMuseum, bookingDate);

      if (bookingService.calculateFee(bookingDTO)>0){
          Booking newBooking =bookingService.Save(bookingDTO);
          return String.valueOf(newBooking.getCost());
      }
        return ("Invalid booking!!");
    }
}

