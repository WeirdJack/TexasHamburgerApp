package com.bhargav.texashamco.repository;

import com.bhargav.texashamco.models.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
}
