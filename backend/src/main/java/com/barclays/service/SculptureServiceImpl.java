package com.barclays.service;

import com.barclays.model.Artist;
import com.barclays.model.Museum;
import com.barclays.model.Sculpture;
import com.barclays.repository.SculptureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

}
