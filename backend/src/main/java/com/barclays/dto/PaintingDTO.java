package com.barclays.dto;

import com.barclays.model.Painting;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PaintingDTO {

    private Long id;
    private String title;
    private int yearCompleted;
    private String medium;
    private String backstory;
    private String style;
    private Long artistId;
    private String artistName;
    private String src;

    public PaintingDTO(Painting painting) {
        BeanUtils.copyProperties(painting,this);
        this.artistId = painting.getArtist().getId();
        this.artistName = painting.getArtist().getName();
    }
}
