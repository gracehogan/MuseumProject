package com.barclays.service;

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
    Painting save(Painting p);
    void deletePaintingById(Long id);
    List<Painting> sortAllByMedium(String medium, String sort);
    List<Painting> sortAllByStyle(String style, String sort);
    List<Painting> sortAllByYearCompleted( String sort);


}
