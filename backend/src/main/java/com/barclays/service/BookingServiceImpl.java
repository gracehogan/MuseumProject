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
    public Booking Save(BookingDTO bookingDTO) {
        Booking booking= new Booking();
        booking.setBookedMuseum(bookingDTO.getBookedMuseum());
        booking.setName(bookingDTO.getName());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setNumberOfPersons(bookingDTO.getNumberOfPersons());
        booking.setCost(calculateFee(bookingDTO));
        booking.setEmail(bookingDTO.getEmail());
        booking.setBookingType(bookingDTO.getBookingType());
        return bookingRepository.save(booking);
    }

    @Override
    public double calculateFee(BookingDTO bookingDTO) {

            BookingStrategy bookingStrategy= BookingStrategyFactory.getBookingStrategy(bookingDTO);
          return  bookingStrategy.calculateFee(bookingDTO);
        }

    @Override
    public BookingDTO createBookingDTO(String name,int number, String bookingType, String email, String bookedMuseum, String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        BookingDTO bookingDTO= new BookingDTO();
        bookingDTO.setNumberOfPersons(number);
        bookingDTO.setBookingType(BookingType.valueOf(bookingType));
        bookingDTO.setEmail(email);
        bookingDTO.setName(name);
        bookingDTO.setBookedMuseum(BookedMuseum.valueOf(bookedMuseum));
        bookingDTO.setBookingDate(LocalDateTime.parse(date,formatter));
        return bookingDTO;
    }

    @Override
    public String getFeeOfValidBooking(BookingDTO bookingDTO) {
        if (this.calculateFee(bookingDTO)>0){
            Booking newBooking =this.Save(bookingDTO);
            return String.valueOf(newBooking.getCost());
        }
        return ("Invalid booking!!");
    }

}

