package com.barclays.service;

import com.barclays.model.Museum;

import java.util.List;

public interface MuseumService {

    List<Museum> findAll();


    Museum findById(Long id);

    Museum save(Museum museum);

    void deleteById(Long id);

}
