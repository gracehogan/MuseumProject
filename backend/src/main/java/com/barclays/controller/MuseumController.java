package com.barclays.controller;


import com.barclays.dto.MuseumDTO;
import com.barclays.model.Museum;
import com.barclays.service.MuseumService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MuseumController {
    private final MuseumService museumService;

    @GetMapping("/museums")
    public List<MuseumDTO> getAllMuseums() {
        log.debug("In the getAllMuseums method");
        List<Museum> museums = museumService.findAll();
        List<MuseumDTO> dtos = new ArrayList<>();
        for (Museum museum : museums) {
            dtos.add(new MuseumDTO(museum));
        }
        return dtos;
    }

    @GetMapping("/museums/{id}")
    public MuseumDTO getMuseum(@PathVariable long id) {
        log.debug("In the getMuseum method");
        Museum museum = museumService.findById(id);
        return new MuseumDTO(museum);
    }

    @PostMapping("/museums")
    public Museum saveMuseum(@RequestBody Museum museum) {
        log.debug("saveMuseum method logged");
        return museumService.save(museum);
    }

    @PutMapping("/museums")
    public Museum updateMuseum(@RequestBody Museum museum) {
        log.debug("updateMuseum method logged");
        return museumService.save(museum);
    }

    @DeleteMapping("/museums/{id}")
    public void deleteMuseumById(@PathVariable Long id) {
        log.debug("deleteMuseumById method logged");
        museumService.deleteById(id);
    }
}
