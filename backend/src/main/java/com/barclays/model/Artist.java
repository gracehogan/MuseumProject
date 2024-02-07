package com.barclays.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int yearOfBirth;
    private int yearOfDeath;
    @JsonManagedReference
    @OneToMany(mappedBy = "artist")
    private List<Painting> paintings;
    @JsonManagedReference
    @OneToMany(mappedBy = "artist")
    private List<Sculpture> sculptures;

}
