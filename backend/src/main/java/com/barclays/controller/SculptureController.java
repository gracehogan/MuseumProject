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
