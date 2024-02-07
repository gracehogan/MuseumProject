package com.barclays.controller;

import com.barclays.model.Artist;
import com.barclays.model.Painting;
import com.barclays.service.PaintingService;
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
public class PaintingController {
    private PaintingService paintingService;

    @GetMapping("/paintings")
    public List<Painting> getPaintings() {
        log.debug("In the getPaintings method");
        return paintingService.findAll();
    }

    @GetMapping("/paintings/{id}")
    public Painting getPainting(@PathVariable long id) {
        log.debug("In the getPainting method");
        return paintingService.findById(id);
    }

    @PostMapping("/paintings")
    public Painting createPainting(@RequestBody Painting painting) {
        log.debug("In the createPaintings method");
        return paintingService.save(painting);
    }

    @PutMapping("/paintings")
    public Painting updatePainting(@RequestBody Painting painting) {
        log.debug("In the updatePaintings method");
        return paintingService.save(painting);
    }

    @DeleteMapping("/paintings/{id}")
    public void deletePainting(@PathVariable Long id) {
        log.debug("In the deletePaintings method");
        paintingService.deletePaintingById(id);
    }
}
