package com.barclays.controller;

import com.barclays.dto.BookingDTO;
import com.barclays.exception.InvalidBookingException;
import com.barclays.model.Artist;
import com.barclays.model.Booking;
import com.barclays.model.enums.BookedMuseum;
import com.barclays.model.enums.BookingType;
import com.barclays.service.ArtistService;
import com.barclays.service.BookingService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

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

