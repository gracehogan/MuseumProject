package com.barclays.controller;

import com.barclays.dto.PaintingDTO;
import com.barclays.dto.SculptureDTO;
import com.barclays.model.Painting;
import com.barclays.model.Sculpture;
import com.barclays.service.SculptureService;
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

    @GetMapping("/sculptures/getById/{id}")
    public SculptureDTO getSculpture(@PathVariable long id) {
        log.debug("In the getSculpture method");
        Sculpture sculpture = sculptureService.findById(id);
        return new SculptureDTO(sculpture);
    }

    @GetMapping("/sculptures/getByMedium/{medium}")
    public List<SculptureDTO> getSculptureByMedium(@PathVariable String medium) {
        log.debug("In the getSculptureByMedium method");
        List<Sculpture> sculptures = sculptureService.findByMedium(medium);
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }

    @GetMapping("/sculptures/getByTitle/{title}")
    public SculptureDTO getSculptureByTitle(@PathVariable String title) {
        log.debug("In the getSculptureByTitle method");
        Sculpture sculpture = sculptureService.findByTitle(title);
        return new SculptureDTO(sculpture);
    }

    @GetMapping("/sculptures/getByMuseum/{museum}")
    public List<SculptureDTO> getSculptureByMuseum(@PathVariable String museum) {
        log.debug("In the getSculptureByMuseum method");
        List<Sculpture> sculptures = sculptureService.findByMuseum(museum);
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }

    @GetMapping("/sculptures/getByAllFields/{search}")
    List<SculptureDTO> getByAllFields(@PathVariable String search) {
        log.debug("In the getSculpturesByAllFields method");
        List<Sculpture> sculptures = new ArrayList<>();

        Sculpture byTitle = sculptureService.findByTitle(search);
        if (byTitle != null) {
            sculptures.add(byTitle);
        }

        List<Sculpture> byArtistName = sculptureService.findByArtistNameContainingIgnoreCase(search);
        if (byArtistName != null) {
            sculptures.addAll(byArtistName);
        }

        List<Sculpture> byMedium = sculptureService.findByMedium(search);
        if (byMedium != null) {
            sculptures.addAll(byMedium);
        }

        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }

    @GetMapping("/sculptures/sortAllByTitle/{sort}")
    List<SculptureDTO> sortAllByTitle(@PathVariable String sort) {
        log.debug("In the sortSculpturesByTitle method");
        List<Sculpture> sculptures = sculptureService.sortAllByTitle(sort);
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }

    @GetMapping("/sculptures/getByArtistName/{artistName}")
    List<SculptureDTO> getByArtistName(@PathVariable String artistName) {
        log.debug("In the getSculpturesByArtistName method");
        List<Sculpture> sculptures = sculptureService.findByArtistNameContainingIgnoreCase(artistName);
        List<SculptureDTO> dtos = new ArrayList<>();
        for (Sculpture sculpture : sculptures) {
            dtos.add(new SculptureDTO(sculpture));
        }
        return dtos;
    }


    @GetMapping("/sculptures/sortAllByYearCompleted/{sort}")
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
