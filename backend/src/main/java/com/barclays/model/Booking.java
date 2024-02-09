package com.barclays.model;

import com.barclays.model.enums.BookedMuseum;
import com.barclays.model.enums.BookingType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    private int numberOfPersons;
    @Enumerated(EnumType.STRING)

    private BookedMuseum bookedMuseum;
    @Enumerated(EnumType.STRING)

    private BookingType bookingType;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime bookingDate;
    private double cost;
    private String bookingSlot;






}
