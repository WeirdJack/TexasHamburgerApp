package com.bhargav.texashamco.service;

import com.bhargav.texashamco.dto.OpenHoursDTO;
import com.bhargav.texashamco.mapper.OpenHoursMapper;
import com.bhargav.texashamco.models.Menu;
import com.bhargav.texashamco.models.OpenHours;
import com.bhargav.texashamco.repository.OpenHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenHoursService {

    @Autowired
    OpenHoursRepository openHoursRepository;

    @Autowired
    OpenHoursMapper openHoursMapper;

    public List<OpenHoursDTO> getAllOpenHours(){

        return openHoursMapper.toOpenHoursDTOs(openHoursRepository.findAll());
    }

    public Page<OpenHours> getOpenHoursByPage(int pageNumber, int pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return openHoursRepository.findAll(pageable);
    }

    public void addOpenHours(OpenHoursDTO openHoursDTO) {

        openHoursRepository.insert(openHoursMapper.toOpenHours(openHoursDTO));
    }

    public void updateOpenHours(OpenHoursDTO openHoursDTO) {

        OpenHours openHours = openHoursMapper.toOpenHours(openHoursDTO);
        OpenHours existing = openHoursRepository.findById(openHours.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find OpenHours with ID: " + openHours.getId())
                ));

        existing.setId(openHours.getId());
        openHoursRepository.save(existing);
    }

    public void deleteOpenHours(OpenHoursDTO openHoursDTO) {

        OpenHours openHours = openHoursMapper.toOpenHours(openHoursDTO);
        OpenHours existing = openHoursRepository.findById(openHours.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find OpenHours with ID: " + openHours.getId())
                ));

        openHoursRepository.delete(existing);
    }
}
