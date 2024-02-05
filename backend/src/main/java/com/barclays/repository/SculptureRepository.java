package com.barclays.repository;

import com.barclays.model.Sculpture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SculptureRepository extends CrudRepository<Sculpture, Long> {

}
