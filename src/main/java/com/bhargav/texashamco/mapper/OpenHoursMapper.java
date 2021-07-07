package com.bhargav.texashamco.mapper;

import com.bhargav.texashamco.dto.MenuDTO;
import com.bhargav.texashamco.dto.OpenHoursDTO;
import com.bhargav.texashamco.models.Menu;
import com.bhargav.texashamco.models.OpenHours;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface OpenHoursMapper {

    OpenHoursDTO toOpenHoursDTO(OpenHours openHours);
    OpenHours toOpenHours(OpenHoursDTO openHoursDTO);
    List<OpenHoursDTO> toOpenHoursDTOs(List<OpenHours> openHours);
    List<OpenHours> toOpenHours(List<OpenHoursDTO> OpenHoursDTOs);

    //Page<OpenHoursDTO> toOpenHoursDTOsPage(Page<OpenHours> openHours);
}
