package com.barclays.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryDTO {

    private String name;
    private String email;
    private String enquiry;
    private LocalDateTime enquiryDate;
}
