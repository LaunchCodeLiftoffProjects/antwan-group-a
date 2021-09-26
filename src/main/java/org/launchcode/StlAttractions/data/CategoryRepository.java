package org.launchcode.StlAttractions.data;

import org.launchcode.StlAttractions.models.Attraction;
import org.launchcode.StlAttractions.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    //Category deleteById(int categoryId);
}
