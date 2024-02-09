package com.barclays.dto;

import com.barclays.model.Painting;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class PaintingDTO {

    private Long id;
    private String title;
    private int yearCompleted;
    private String medium;
    private String backstory;
    private String style;
    private Long artistId;
    private String artistName;
    private Long museumId;
    private String museumName;
    private String src;

    public PaintingDTO(Painting painting) {
        BeanUtils.copyProperties(painting,this);
        this.artistId = painting.getArtist().getId();
        this.artistName = painting.getArtist().getName();
        this.museumId = painting.getMuseum().getId();
        this.museumName = painting.getMuseum().getName();
    }


}
