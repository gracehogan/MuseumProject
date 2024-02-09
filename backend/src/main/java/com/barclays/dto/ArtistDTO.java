package com.barclays.dto;

import com.barclays.model.Artist;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


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
