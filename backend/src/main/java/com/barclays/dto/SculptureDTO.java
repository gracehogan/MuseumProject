package com.barclays.dto;

import com.barclays.model.Sculpture;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class SculptureDTO {

    private Long id;
    private String title;
    private int yearCompleted;
    private String medium;
    private String backstory;
    private Long artistId;
    private String artistName;
    private String src;

    public SculptureDTO(Sculpture sculpture) {
        BeanUtils.copyProperties(sculpture,this);
        this.artistId = sculpture.getArtist().getId();
        this.artistName = sculpture.getArtist().getName();
    }
}
