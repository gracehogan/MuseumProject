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
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    private final BookingService bookingService;


    @PostMapping("/saveBooking")
    public Booking saveNewBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.save(bookingDTO);
    }


    @PostMapping("/estimateFee")
    public double estimateBookingFee(@RequestBody BookingDTO bookingDTO) {
        return bookingService.setFeeOfBooking(bookingDTO);
    }



    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBookingById(@PathVariable Long id) {
        log.debug("deleteBookingById method logged");
        bookingService.deleteById(id);
    }
}

