package com.barclays.service;

import com.barclays.dto.SculptureDTO;
import com.barclays.model.Artist;
import com.barclays.model.Museum;
import com.barclays.model.Painting;
import com.barclays.model.Sculpture;
import com.barclays.repository.SculptureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class SculptureServiceImpl implements SculptureService {

    private SculptureRepository sculptureRepository;

    @Override
    public List<Sculpture> findAll() {
        List<Sculpture> sculpture = new ArrayList<>();
        Iterable<Sculpture> messagesIts = sculptureRepository.findAll();
        messagesIts.forEach(sculpture::add);
        return sculpture;
    }

    @Override
    public Sculpture findById(Long id) {
        Optional<Sculpture> sculpture = sculptureRepository.findById(id);
        return sculpture.orElseGet(Sculpture::new);
    }

    @Override
    public Sculpture save(Sculpture sculpture) {
        return sculptureRepository.save(sculpture);
    }

    @Override
    public void deleteById(long id) {
        sculptureRepository.deleteById(id);
    }

    @Override
    public Sculpture findByTitle(String title) {
        return sculptureRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Sculpture> findByMedium(String medium) {
        return sculptureRepository.findAllByMediumIgnoreCase(medium);
    }

    @Override
    public List<Sculpture> sortAllByYearCompleted(String sort) {
        return sortListYear(findAll(),sort);
    }

    @Override
    public List<Sculpture> sortAllByTitle(String sort) {
        return sortListTitle(findAll(),sort);
    }

    @Override
    public List<Sculpture> findByMuseum(String museum) {
        return sculptureRepository.findAllByMuseumNameIgnoreCase(museum);
    }

    @Override
    public List<SculptureDTO> findByArtistName(List<SculptureDTO> sculptures, String name) {
        List<SculptureDTO> sculpturesByArtistName = new ArrayList<>();
        for(SculptureDTO sculpture : sculptures) {
            if (sculpture.getArtistName().equalsIgnoreCase(name)) {
                sculpturesByArtistName.add(sculpture);
            }
        }
        return sculpturesByArtistName;
    }

    public List<Sculpture> sortListTitle(List<Sculpture> sculptures, String sort) {
        if (sort.equals("asc")) {
            Collections.sort(sculptures, Comparator.comparing(Sculpture::getTitle));
        } else if (sort.equals("desc")) {
            Collections.sort(sculptures, Comparator.comparing(Sculpture::getTitle).reversed());
        }
        return sculptures;
    }

    public List<Sculpture> sortListYear(List<Sculpture> sculptures, String sort) {
        if (sort.equals("asc")) {
            Collections.sort(sculptures, Comparator.comparing(Sculpture::getYearCompleted));
        } else if (sort.equals("desc")) {
            Collections.sort(sculptures, Comparator.comparing(Sculpture::getYearCompleted).reversed());
        }
        return sculptures;
    }
}
