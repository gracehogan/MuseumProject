package com.barclays.dto;

import com.barclays.model.Museum;
import com.barclays.model.Painting;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class MuseumDTO {

    private Long id;
    private String name;
    private String location;
    private String curator;


    public MuseumDTO(Museum museum) {
        BeanUtils.copyProperties(museum,this);
    }


}
