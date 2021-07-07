package com.bhargav.texashamco.service;

import com.bhargav.texashamco.dto.LocationDTO;
import com.bhargav.texashamco.mapper.LocationMapper;
import com.bhargav.texashamco.models.Location;
import com.bhargav.texashamco.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    LocationMapper locationMapper;

    public List<LocationDTO> getAllLocations(){

        return locationMapper.toLocationDTOs(locationRepository.findAll());
    }

    public Page<Location> getLocationsByPage(int pageNumber, int pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return locationRepository.findAll(pageable);
    }

    public Page<Location> getLocationsByStatus(String currentStatus){

        Pageable pageable = PageRequest.of(0, 10);

        Query query = new Query().with(pageable);
        query.addCriteria(Criteria.where("status").is(currentStatus));

        List<Location> filteredLocations =
                mongoTemplate.find(query, Location.class, "location");
        Page<Location> locationPage = PageableExecutionUtils.getPage(
                filteredLocations,
                pageable,
                () -> mongoTemplate.count(query, Location.class));

        return locationPage;
    }

    public void addLocation(LocationDTO locationDTO) {

        locationRepository.insert(locationMapper.toLocation(locationDTO));
    }

    public void updateLocation(LocationDTO locationDTO) {

        Location location = locationMapper.toLocation(locationDTO);
        Location existing = locationRepository.findById(location.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Location with ID: " + location.getId())
                ));

        existing.setId(location.getId());
        existing.setName(location.getName());
        locationRepository.save(existing);
    }

    public void deleteLocation(LocationDTO locationDTO) {

        Location location = locationMapper.toLocation(locationDTO);
        Location existing = locationRepository.findById(location.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Location with ID: " + location.getId())
                ));

        locationRepository.delete(existing);
    }
}
