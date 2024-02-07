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
    @Column(name = "numberOfPersons")
    private int numberOfPersons;
    @Enumerated(EnumType.STRING)
    @Column(name = "bookedMuseum")
    private BookedMuseum bookedMuseum;
    @Enumerated(EnumType.STRING)
    @Column(name = "bookingType")
    private BookingType bookingType;

    @Column(name = "bookingDate",columnDefinition = "DATETIME")
    private LocalDateTime bookingDate;
    private double cost;






}
