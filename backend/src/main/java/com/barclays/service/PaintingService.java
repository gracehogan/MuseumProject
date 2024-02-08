package com.barclays.service;

import com.barclays.dto.PaintingDTO;
import com.barclays.model.Painting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaintingService {

    List<Painting> findAll();
    Painting findById(Long id);
    Painting findByTitle(String title);
    List<Painting> findByMedium(String medium);
    List<Painting> findByStyle(String style);
    List<Painting> findByMuseum(String museum);
    List<Painting> sortAllByTitle(String sort);
    List<Painting> findByArtistNameContainingIgnoreCase(String artistName);
    Painting save(Painting p);
    void deletePaintingById(Long id);
    List<Painting> sortAllByYearCompleted( String sort);


}
