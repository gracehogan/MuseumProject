package com.barclays.service;

import com.barclays.model.Painting;
import com.barclays.repository.PaintingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PaintingServiceImpl implements PaintingService{

     private PaintingRepository paintingRepository;

    @Override
    public List<Painting> findAll() {
        List<Painting> paintings = new ArrayList<>();
        Iterable<Painting> paintingIterable = paintingRepository.findAll();
        paintingIterable.forEach(paintings::add);
        return paintings;
    }

    @Override
    public Painting findById(Long id) {
        Optional<Painting> painting = paintingRepository.findById(id);
        return painting.orElseGet(Painting::new);
    }

    @Override
    public Painting save(Painting p) {
        return paintingRepository.save(p);
    }

    @Override
    public void deletePaintingById(Long id) {
        paintingRepository.deleteById(id);
    }


}
