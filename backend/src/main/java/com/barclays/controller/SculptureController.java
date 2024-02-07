package com.barclays.controller;

import com.barclays.model.Artist;
import com.barclays.model.Museum;
import com.barclays.model.Painting;
import com.barclays.model.Sculpture;
import com.barclays.service.ArtistService;
import com.barclays.service.MuseumService;
import com.barclays.service.SculptureService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class SculptureController {
    private SculptureService sculptureService;

    @GetMapping("/sculptures")
    public List<Sculpture> getAllSculptures() {
        log.debug("In the getAllSculptures method");
        return sculptureService.findAll();
    }

    @GetMapping("/sculptures/{id}")
    public Sculpture getSculpture(@PathVariable long id) {
        log.debug("In the getSculpture method");
        return sculptureService.findById(id);
    }



    @GetMapping("/getSculpturesByMedium")
    public List<Sculpture> getPaintingByMedium(@PathParam("medium") String medium) {
        log.debug("In the getPaintingByStyle method");
        return sculptureService.findByMedium(medium);
    }

    @GetMapping("/sortSculpturesByMedium/{medium}/{sort}")
    List<Sculpture> sortAllByMedium(@PathVariable String medium, @PathVariable String sort) {
        return sculptureService.sortAllByMedium(medium, sort);
    }

    @GetMapping("/sortAllSculpureByYearCompleted/{sort}")
    List<Sculpture> sortAllByYearCompleted(@PathVariable String sort) {
        return sculptureService.sortAllByYearCompleted(sort);
    }

    @PostMapping("/sculptures")
    public Sculpture createSculpture(@RequestBody Sculpture sculpture) {
        log.debug("In the createSculpture method");
        return sculptureService.save(sculpture);
    }

    @PutMapping("/sculptures")
    public Sculpture updateSculpture(@RequestBody Sculpture sculpture) {
        log.debug("In the updateSculpture method");
        return sculptureService.save(sculpture);
    }

    @DeleteMapping("/sculptures/{id}")
    public void deleteSculpture(@PathVariable long id) {
        log.debug("In the deleteSculpture method");
        sculptureService.deleteById(id);
    }
}
