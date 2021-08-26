package org.launchcode.StlAttractions.data;

import org.launchcode.StlAttractions.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
