package com.barclays.service;

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
public class SculptureServiceImpl implements SculptureService{

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
    public List<Sculpture> sortAllByMedium(String medium, String sort) {
        return sortListTitle(findByMedium(medium), sort);
    }

    @Override
    public List<Sculpture> sortAllByYearCompleted(String sort) {
        return sortListYear(findAll(),sort);
    }

    public List<Sculpture> sortListTitle(List<Sculpture> paintings, String sort) {
        if (sort.equals("asc")) {
            Collections.sort(paintings, Comparator.comparing(Sculpture::getTitle));
        } else if (sort.equals("desc")) {
            Collections.sort(paintings, Comparator.comparing(Sculpture::getTitle).reversed());
        }
        return paintings;
    } public List<Sculpture> sortListYear(List<Sculpture> paintings, String sort) {
        if (sort.equals("asc")) {
            Collections.sort(paintings, Comparator.comparing(Sculpture::getYearCompleted));
        } else if (sort.equals("desc")) {
            Collections.sort(paintings, Comparator.comparing(Sculpture::getYearCompleted).reversed());
        }
        return paintings;
    }
}
