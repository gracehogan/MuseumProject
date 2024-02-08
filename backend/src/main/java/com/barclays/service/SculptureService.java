package com.barclays.service;

import com.barclays.dto.SculptureDTO;
import com.barclays.model.Artist;
import com.barclays.model.Museum;
import com.barclays.model.Painting;
import com.barclays.model.Sculpture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SculptureService {
    List<Sculpture> findAll();

    Sculpture findById(Long id);

    Sculpture save(Sculpture sculpture);

    void deleteById(long id);

    List<Sculpture> findByMedium(String medium);

    Sculpture findByTitle(String title);

    List<SculptureDTO> findByArtistName(List<SculptureDTO> sculptures, String name);

    List<Sculpture> sortAllByYearCompleted(String sort);

    List<Sculpture> sortAllByTitle(String sort);

}
