package com.barclays.repository;

import com.barclays.model.Painting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Long> {

}
