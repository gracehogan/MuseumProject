package com.barclays.controller;

import com.barclays.dto.PaintingDTO;
import com.barclays.model.Painting;
import com.barclays.service.PaintingService;
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

    @GetMapping("/paintings/getById/{id}")
    public PaintingDTO getPainting(@PathVariable long id) {
        log.debug("In the getPainting method");
        Painting painting = paintingService.findById(id);
        return new PaintingDTO(painting);
    }

    @GetMapping("/paintings/getByTitle/{title}")
    public PaintingDTO getPaintingByTitle(@PathVariable String title) {
        log.debug("In the getPaintingByTitle method");
        Painting painting = paintingService.findByTitle(title);
        return new PaintingDTO(painting);
    }

    @GetMapping("/paintings/getByStyle/{style}")
    public List<PaintingDTO> getPaintingByStyle(@PathVariable String style) {
        log.debug("In the getPaintingByStyle method");
        List<Painting> paintings = paintingService.findAllByStyleContainingIgnoreCase(style);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/paintings/getByMuseum/{museum}")
    public List<PaintingDTO> getPaintingByMuseum(@PathVariable String museum) {
        log.debug("In the getPaintingByMuseum method");
        List<Painting> paintings = paintingService.findByMuseum(museum);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/paintings/getByMedium/{medium}")
    public List<PaintingDTO> getPaintingByMedium(@PathVariable String medium) {
        log.debug("In the getPaintingByMedium method");
        List<Painting> paintings = paintingService.findAllByMediumContainingIgnoreCase(medium);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/paintings/sortAllByTitle/{sort}")
    List<PaintingDTO> sortAllByTitle(@PathVariable String sort) {
        log.debug("In the sortSculpturesByTitle method");
        List<Painting> paintings = paintingService.sortAllByTitle(sort);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/paintings/getByArtistName/{artistName}")
    List<PaintingDTO> getByArtistName(@PathVariable String artistName) {
        log.debug("In the getPaintingsByArtistName method");
        List<Painting> paintings = paintingService.findByArtistNameContainingIgnoreCase(artistName);
        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }

    @GetMapping("/paintings/getByAllFields/{search}")
    List<PaintingDTO> getByAllFields(@PathVariable String search) {
        log.debug("In the getPaintingsByAllFields method");
        List<Painting> paintings = new ArrayList<>();

        Painting byTitle = paintingService.findByTitle(search);
        if (byTitle != null) {
            paintings.add(byTitle);
        }

        List<Painting> byArtistName = paintingService.findByArtistNameContainingIgnoreCase(search);
        if (byArtistName != null) {
            paintings.addAll(byArtistName);
        }

        List<Painting> byStyle = paintingService.findAllByStyleContainingIgnoreCase(search);
        if (byStyle != null) {
            paintings.addAll(byStyle);
        }

        List<Painting> byMedium = paintingService.findAllByMediumContainingIgnoreCase(search);
        if (byMedium != null) {
            paintings.addAll(byMedium);
        }

        List<PaintingDTO> dtos = new ArrayList<>();
        for (Painting painting : paintings) {
            dtos.add(new PaintingDTO(painting));
        }
        return dtos;
    }


    @GetMapping("/paintings/sortAllByYearCompleted/{sort}")
    List<PaintingDTO> sortAllByYearCompleted(@PathVariable String sort) {
        log.debug("In the sortPaintingsByYearCompleted method");
        List<Painting> paintings = paintingService.sortAllByYearCompleted(sort);
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
