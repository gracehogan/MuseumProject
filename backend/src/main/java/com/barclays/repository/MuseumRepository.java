package com.barclays.repository;

import com.barclays.model.Museum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MuseumRepository extends CrudRepository<Museum,Long> {

}
