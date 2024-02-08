package com.barclays.dto;

import com.barclays.model.Sculpture;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class SculptureDTO {

    private Long id;
    private String title;
    private int yearCompleted;
    private String medium;
    private String backstory;
    private Long artistId;
    private String artistName;
    private Long museumId;
    private String museumName;
    private String src;

    public SculptureDTO(Sculpture sculpture) {
        BeanUtils.copyProperties(sculpture,this);
        this.artistId = sculpture.getArtist().getId();
        this.artistName = sculpture.getArtist().getName();
        this.museumId = sculpture.getMuseum().getId();
        this.museumName = sculpture.getMuseum().getName();
    }
}
