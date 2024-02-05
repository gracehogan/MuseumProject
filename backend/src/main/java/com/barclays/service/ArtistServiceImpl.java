package com.barclays.service;

import com.barclays.model.Artist;
import com.barclays.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;

    @Override
    public List<Artist> findAllArtists() {
        List<Artist> artists = new ArrayList<>();
        Iterable<Artist> artistIts = artistRepository.findAll();
        artistIts.forEach(artists::add);
        return artists;
    }

    @Override
    public Artist findArtistById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.orElseGet(Artist::new);
    }

    @Override
    public Artist save(Artist a) {
        return artistRepository.save(a);
    }

    @Override
    public List<Artist> findByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }


}
