package com.barclays.controller;


import com.barclays.model.Museum;
import com.barclays.service.MuseumService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin()
@RestController
@Slf4j
@AllArgsConstructor
public class MuseumController {
    private final MuseumService museumService;

    @GetMapping("/museums")
    public List<Museum> getAllMuseums() {
        log.debug("In the getAllMuseums method");
        return museumService.findAll();
    }

    @GetMapping("/museums/{id}")
    public Museum getMuseum(@PathVariable Long id) {
        log.debug("In the getMuseum method");
        return museumService.findById(id);
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
