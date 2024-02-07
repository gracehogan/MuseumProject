package com.barclays.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Painting  {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int yearCompleted;

    private String medium;

    private String backstory;

    private String style;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "museum_id")
    private Museum museum;

    private String src;

}
