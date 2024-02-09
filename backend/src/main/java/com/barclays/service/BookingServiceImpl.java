package com.barclays.service;

import com.barclays.dto.BookingDTO;
import com.barclays.model.Booking;
import com.barclays.model.enums.BookedMuseum;
import com.barclays.model.enums.BookingType;
import com.barclays.repository.BookingRepository;
import com.barclays.strategy.BookingStrategy;
import com.barclays.strategy.BookingStrategyFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

   private BookingRepository bookingRepository;


    @Override
    public Booking findById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.orElseGet(Booking::new);
    }

    @Override
    public Booking save(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setBookedMuseum(bookingDTO.getBookedMuseum());
        booking.setName(bookingDTO.getName());
        booking.setBookingDate(LocalDateTime.now());
        booking.setNumberOfPersons(bookingDTO.getNumberOfPersons());
        booking.setCost(calculateFee(bookingDTO));
        booking.setBookingSlot(bookingDTO.getBookingSlot());
        booking.setEmail(bookingDTO.getEmail());
        return bookingRepository.save(booking);
    }


    @Override
    public double calculateFee(BookingDTO bookingDTO) {

        BookingStrategy bookingStrategy= BookingStrategyFactory.getBookingStrategy(bookingDTO);
        return  bookingStrategy.calculateFee(bookingDTO);
    }


    @Override
    public double setFeeOfBooking(BookingDTO bookingDTO) {
        bookingDTO.setBookingDate(LocalDateTime.now());
        double fee =this.calculateFee(bookingDTO);
            bookingDTO.setCost(fee);
          return bookingDTO.getCost();

    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }


}

