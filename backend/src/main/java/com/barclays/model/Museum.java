package com.barclays.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Museum {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private String curator;
    @JsonManagedReference
    @OneToMany(mappedBy = "museum")
    private List<Painting> paintings;
    @JsonManagedReference
    @OneToMany(mappedBy = "museum")
    private List<Sculpture> sculptures;


}
