package org.launchcode.StlAttractions.data;

import org.launchcode.StlAttractions.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}