package com.barclays.dto;

import com.barclays.model.Artist;
import com.barclays.model.Museum;
import com.barclays.model.Painting;
import com.barclays.model.Sculpture;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class ArtistDTO {


    private Long id;
    private String name;
    private int yearOfBirth;
    private int yearOfDeath;

    public ArtistDTO(Artist artist) {
        BeanUtils.copyProperties(artist,this);
    }


}
