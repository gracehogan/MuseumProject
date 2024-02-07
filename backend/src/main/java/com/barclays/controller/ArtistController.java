package com.barclays.controller;

import com.barclays.model.Artist;
import com.barclays.service.ArtistService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        log.debug("In the getAllArtists method");
        return artistService.findAllArtists();
    }

    @GetMapping("/artist/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        log.debug("In the getArtistById method: "+id);
        return artistService.findArtistById(id);
    }

    @GetMapping("/artist")
    @SuppressWarnings("java:S1854")
    public List<Artist> findArtistByName(@PathParam("name") String name) {
        log.debug("In the findArtistByName method");
        List<Artist> artist = Collections.emptyList();
        if (StringUtils.isNotBlank(name)) {
            artist = artistService.findByName(name);
        } else {
            artist = artistService.findAllArtists();
        }
        return artist;
    }

    @PostMapping("/artist")
    public Artist createArtist(@RequestBody Artist artist) {
        log.debug("In the createArtist method");
        return artistService.save(artist);
    }

    @PutMapping("/artists")
    public Artist updateArtist(@RequestBody Artist artist) {
        log.debug("In the updateArtist method");
        return artistService.save(artist);
    }

    @DeleteMapping("/artist/{id}")
    public void deleteArtist(@PathVariable Long id) {
        log.debug("In the deleteArtist method: "+id);
        artistService.deleteArtist(id);
    }

}