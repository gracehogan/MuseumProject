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

//    @PostMapping("/saveBooking/{name}/{numberOfPersons}/{bookingType}/{email}/{bookedMuseum}/{bookingSlot}")
//    public Booking saveBooking(@PathVariable String name,@PathVariable int numberOfPersons,@PathVariable  String bookingType,
//                               @PathVariable  String email,@PathVariable  String bookedMuseum,@PathVariable String bookingSlot) {
//        BookingDTO bookingDTO = bookingService.createBookingDTO(name,numberOfPersons, bookingType, email, bookedMuseum,bookingSlot);
//        return bookingService.save(bookingDTO);
//    }

    @PostMapping("/saveBooking")
    public Booking saveNewBooking (@RequestBody BookingDTO bookingDTO){
        return bookingService.save(bookingDTO);
    }
    @GetMapping("/estimateFee/{name}/{numberOfPersons}/{bookingType}/{email}/{bookedMuseum}/{bookingSlot}")
    public String estimateBookingFee(@PathVariable String name,@PathVariable int numberOfPersons,@PathVariable  String bookingType,
                                     @PathVariable  String email,@PathVariable  String bookedMuseum,@PathVariable String bookingSlot) {
        BookingDTO bookingDTO = bookingService.createBookingDTO(name,numberOfPersons, bookingType, email, bookedMuseum,bookingSlot);
        return bookingService.setFeeOfBooking(bookingDTO);
    }
    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBookingById(@PathVariable Long id) {
        log.debug("deleteBookingById method logged");
        bookingService.deleteById(id);
    }
}

