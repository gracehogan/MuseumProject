package com.barclays.controller;

import com.barclays.dto.PaintingDTO;
import com.barclays.model.Painting;
import com.barclays.service.PaintingService;
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
public class PaintingController {
    private PaintingService paintingService;

    @GetMapping("/paintings")
    public List<PaintingDTO> getPaintings() {
        log.debug("In the getPaintings method");
        List<Painting> paintings = paintingService.findAll();
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/paintings/{id}")
    public PaintingDTO getPainting(@PathVariable long id) {
        log.debug("In the getPainting method");
        Painting painting = paintingService.findById(id);
        return new PaintingDTO(painting);
    }

    @GetMapping("/getPaintingByTitle")
    public PaintingDTO getPaintingByName(@PathParam("title") String title) {
        log.debug("In the getPaintingByName method");
        Painting painting = paintingService.findByTitle(title);
        return new PaintingDTO(painting);
    }

    @GetMapping("/getPaintingByStyle")
    public List<PaintingDTO> getPaintingByStyle(@PathParam("style") String style) {
        log.debug("In the getPaintingByStyle method");
        List<Painting> paintings = paintingService.findByStyle(style);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/getPaintingByMedium")
    public List<PaintingDTO> getPaintingByMedium(@PathParam("medium") String medium) {
        log.debug("In the getPaintingByMedium method");
        List<Painting> paintings = paintingService.findByMedium(medium);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/sortPaintingsByMedium/{medium}/{sort}")
    List<PaintingDTO> sortAllByMedium(@PathVariable String medium, @PathVariable String sort) {
        log.debug("In the sortPaintingsByMedium method");
        List<Painting> paintings = paintingService.sortAllByMedium(medium,sort);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/sortPaintingsByYearCompleted/{sort}")
    List<PaintingDTO> sortAllByYearCompleted(@PathVariable String sort) {
        log.debug("In the sortPaintingsByYearCompleted method");
        List<Painting> paintings = paintingService.sortAllByYearCompleted(sort);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/sortPaintingsByStyle/{style}/{sort}")
    List<PaintingDTO> sortAllByStyle(@PathVariable String style, @PathVariable String sort) {
        log.debug("In the sortPaintingsByStyle method");
        List<Painting> paintings = paintingService.sortAllByStyle(style,sort);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
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
