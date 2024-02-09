package com.barclays.repository;

import com.barclays.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {
    List<Painting> findAllByMediumContainingIgnoreCase(String medium);
    List<Painting> findAllByStyleContainingIgnoreCase(String style);
    List<Painting> findAllByMuseumNameIgnoreCase(String museum);
    Painting findByTitleContainingIgnoreCase(String title);
    List<Painting> findByArtistNameContainsIgnoreCase(String artistName);
}
