package org.launchcode.StlAttractions.data;

import org.launchcode.StlAttractions.models.Attraction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttractionRepository extends CrudRepository<Attraction, Integer> {

}