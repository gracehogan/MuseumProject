package com.barclays.dto;


import com.barclays.model.enums.BookedMuseum;
import com.barclays.model.enums.BookingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private String name;
    private String email;
    private int numberOfPersons;
    private BookedMuseum bookedMuseum;
    private BookingType bookingType;
    private LocalDateTime bookingDate;
    private double cost;
    private String bookingSlot;
}
