package com.barclays.service;

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
    Sculpture findByTitle(String title);
    List<Sculpture> findByMedium(String medium);

    List<Sculpture> sortAllByMedium(String medium, String sort);

    List<Sculpture> sortAllByYearCompleted( String sort);
}
