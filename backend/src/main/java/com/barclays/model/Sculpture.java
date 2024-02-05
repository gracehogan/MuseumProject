package com.barclays.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Sculpture  {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int yearCompleted;
    private String medium;
    private String backstory;
}
