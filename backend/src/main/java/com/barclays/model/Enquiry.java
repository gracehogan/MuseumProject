package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String enquiryText;
    @Column(nullable = false)
    private String enquiryType;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime enquiryDate;

    //name
    //email
    //enquiryType
    //enquiryType
    //date


}
