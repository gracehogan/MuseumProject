package com.barclays.service;

import com.barclays.model.Artist;
import com.barclays.model.Museum;
import com.barclays.repository.MuseumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@AllArgsConstructor
public class MuseumServiceImpl implements MuseumService {
    MuseumRepository repository;
    @Override
    public List<Museum> findAll() {
        List<Museum> museums = new ArrayList<>();
        Iterable<Museum> museumIts = repository.findAll();
        museumIts.forEach(museums::add);
        log.debug("findAll method logged");
        return museums;
    }

    @Override
    public Museum findById(@PathVariable Long id) {
        Optional<Museum> museum=repository.findById(id);
        log.debug("findById method logged");
        return museum.orElseGet(()-> new Museum());
    }

    @Override
    public Museum save(Museum museum) {
        log.debug("save method logged");
        return repository.save(museum);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("deleteById method logged");
         repository.deleteById(id);
    }




}
