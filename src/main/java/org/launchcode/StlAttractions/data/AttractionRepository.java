package org.launchcode.StlAttractions.data;

import org.launchcode.StlAttractions.models.Attraction;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface AttractionRepository extends PagingAndSortingRepository<Attraction, Integer> {
}