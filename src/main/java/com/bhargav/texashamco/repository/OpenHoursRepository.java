package com.bhargav.texashamco.repository;

import com.bhargav.texashamco.models.OpenHours;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenHoursRepository extends MongoRepository<OpenHours, String> {
}
