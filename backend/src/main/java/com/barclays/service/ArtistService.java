package com.barclays.service;

import com.barclays.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> findAllArtists();

    Artist findArtistById(Long id);

    Artist save(Artist a);

    List<Artist> findByName(String name);

    void deleteArtist(Long id);

}
