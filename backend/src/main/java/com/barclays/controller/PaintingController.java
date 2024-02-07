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

    @GetMapping("/paintingByTitle")
    public Painting getPaintingByName(@PathParam("title") String title) {
        log.debug("In the getPainting method");
        return paintingService.findByTitle(title);
    }

    @GetMapping("/getPaintingByStyle")
    public List<Painting> getPaintingByStyle(@PathParam("style") String style) {
        log.debug("In the getPaintingByStyle method");
        return paintingService.findByStyle(style);
    }

    @GetMapping("/getPaintingByMedium")
    public List<Painting> getPaintingByMedium(@PathParam("medium") String medium) {
        log.debug("In the getPaintingByStyle method");
        return paintingService.findByMedium(medium);
    }

    @GetMapping("/sortPaintingsByMedium/{medium}/{sort}")
    List<Painting> sortAllByMedium(@PathVariable String medium,@PathVariable String sort){
        return paintingService.sortAllByMedium(medium,sort);
    }

    @GetMapping("/sortPaintingsByYearCompleted/{sort}")
    List<Painting> sortAllByYearCompleted(@PathVariable String sort){
        return paintingService.sortAllByYearCompleted(sort);
    }

    @GetMapping("/sortPaintingsByStyle/{style}/{sort}")
    List<Painting> sortAllByStyle(@PathVariable String style,@PathVariable String sort){
        return paintingService.sortAllByStyle(style,sort);
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
