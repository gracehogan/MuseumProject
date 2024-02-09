package com.barclays.repository;

import com.barclays.model.Painting;
import com.barclays.model.Sculpture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SculptureRepository extends CrudRepository<Sculpture, Long> {
    List<Sculpture> findAllByMediumContainingIgnoreCase(String medium);
    List<Sculpture> findAllByMuseumNameIgnoreCase(String museum);
    Sculpture findByTitleContainingIgnoreCase(String title);
    List<Sculpture> findByArtistNameContainingIgnoreCase(String name);
}
