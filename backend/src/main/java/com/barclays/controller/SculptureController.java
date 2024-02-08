package com.barclays.controller;

import com.barclays.dto.SculptureDTO;
import com.barclays.model.Sculpture;
import com.barclays.service.SculptureService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class SculptureController {
    private SculptureService sculptureService;


    @GetMapping("/sculptures")
    public List<SculptureDTO> getSculptures() {
        log.debug("In the getSculptures method");
        List<Sculpture> sculptures = sculptureService.findAll();
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }

    @GetMapping("/sculptures/{id}")
    public SculptureDTO getSculpture(@PathVariable long id) {
        log.debug("In the getSculpture method");
        Sculpture sculpture = sculptureService.findById(id);
        return new SculptureDTO(sculpture);
    }

    @GetMapping("/getByMedium")
    public List<SculptureDTO> getSculptureByMedium(@PathParam("medium") String medium) {
        log.debug("In the getSculptureByMedium method");
        List<Sculpture> sculptures = sculptureService.findByMedium(medium);
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }

    @GetMapping("/getByTitle")
    public SculptureDTO getSculptureByTitle(@PathParam("title") String title) {
        log.debug("In the getSculptureByTitle method");
        Sculpture sculpture = sculptureService.findByTitle(title);
        return new SculptureDTO(sculpture);
    }

    @GetMapping("/sortByTitle/{sort}")
    List<SculptureDTO> sortAllByTitle(@PathVariable String sort) {
        log.debug("In the sortSculpturesByTitle method");
        List<Sculpture> sculptures = sculptureService.sortAllByTitle(sort);
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }

    @GetMapping("/getByArtistName/{name}")
    List<SculptureDTO> getByArtistName(@PathVariable String name) {
        log.debug("In the getSculpturesByArtistName method");
        List<Sculpture> sculptures = sculptureService.findAll();
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        sculptureService.findByArtistName(dtos, name);
        return dtos;
    }


    @GetMapping("/sortByYearCompleted/{sort}")
    List<SculptureDTO> sortAllByYearCompleted(@PathVariable String sort) {
        log.debug("In the sortSculpturesByYearCompleted method");
        List<Sculpture> sculptures = sculptureService.sortAllByYearCompleted(sort);
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
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
