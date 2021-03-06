package com.bhargav.texashamco.repository;

import com.bhargav.texashamco.models.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {

    Location findByName(String locationName, String newLocationName);
}
