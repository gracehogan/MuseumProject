package com.barclays.service;

import com.barclays.model.Painting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaintingService {

    List<Painting> findAll();

    Painting findById(Long id);

    Painting save(Painting p);

    void deletePaintingById(Long id);


}
