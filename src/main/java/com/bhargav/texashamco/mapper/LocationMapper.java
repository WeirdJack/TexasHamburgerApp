package com.bhargav.texashamco.mapper;

import com.bhargav.texashamco.dto.LocationDTO;
import com.bhargav.texashamco.models.Location;
import com.bhargav.texashamco.models.OpenHours;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MenuMapper.class, ReservationMapper.class, OpenHoursMapper.class, AddressMapper.class, ItemMapper.class})
public interface LocationMapper {

    LocationDTO toLocationDTO(Location location);
    Location toLocation(LocationDTO locationDTO);
    List<LocationDTO> toLocationDTOs(List<Location> locations);
    List<Location> toLocations(List<LocationDTO> locationsDTOs);

    //Page<LocationDTO> toLocationDTOsPage(Page<Location> locations);
    //Page<Location> toLocationsPage(Page<LocationDTO> locationsDTOs);
}
