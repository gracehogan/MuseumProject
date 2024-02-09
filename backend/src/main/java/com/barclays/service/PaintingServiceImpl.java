package com.barclays.service;

import com.barclays.dto.PaintingDTO;
import com.barclays.dto.SculptureDTO;
import com.barclays.model.Painting;
import com.barclays.repository.PaintingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class PaintingServiceImpl implements PaintingService {

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
    public Painting findByTitle(String title) {
        return paintingRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Painting> findAllByMediumContainingIgnoreCase(String medium) {
        return paintingRepository.findAllByMediumContainingIgnoreCase(medium);
    }

    @Override
    public List<Painting> findAllByStyleContainingIgnoreCase(String style) {
        return paintingRepository.findAllByStyleContainingIgnoreCase(style);
    }

    @Override
    public List<Painting> findByMuseum(String museum) {
        return paintingRepository.findAllByMuseumNameIgnoreCase(museum);
    }

    @Override
    public Painting save(Painting p) {
        return paintingRepository.save(p);
    }

    @Override
    public void deletePaintingById(Long id) {
        paintingRepository.deleteById(id);
    }

    @Override
    public List<Painting> sortAllByYearCompleted(String sort) {
        return sortListYear(findAll(),sort);
    }

    @Override
    public List<Painting> sortAllByTitle(String sort) {
        return sortListTitle(findAll(),sort);
    }

    @Override
    public List<Painting> findByArtistNameContainingIgnoreCase(String artistName) {
        return paintingRepository.findByArtistNameContainsIgnoreCase(artistName);
    }

    public List<Painting> sortListTitle(List<Painting> paintings, String sort) {
        if (sort.equals("asc")) {
            Collections.sort(paintings, Comparator.comparing(Painting::getTitle));
        } else if (sort.equals("desc")) {
            Collections.sort(paintings, Comparator.comparing(Painting::getTitle).reversed());
        }
        return paintings;
    } public List<Painting> sortListYear(List<Painting> paintings, String sort) {
        if (sort.equals("asc")) {
            Collections.sort(paintings, Comparator.comparing(Painting::getYearCompleted));
        } else if (sort.equals("desc")) {
            Collections.sort(paintings, Comparator.comparing(Painting::getYearCompleted).reversed());
        }
        return paintings;
    }

}
