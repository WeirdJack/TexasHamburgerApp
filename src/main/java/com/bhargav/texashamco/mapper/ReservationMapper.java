package com.bhargav.texashamco.mapper;

import com.bhargav.texashamco.dto.MenuDTO;
import com.bhargav.texashamco.dto.OpenHoursDTO;
import com.bhargav.texashamco.dto.ReservationDTO;
import com.bhargav.texashamco.models.OpenHours;
import com.bhargav.texashamco.models.Reservation;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationDTO toReservationDTO(Reservation reservation);
    Reservation toReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> toReservationDTOs(List<Reservation> reservations);
    List<Reservation> toReservations(List<ReservationDTO> reservationDTOs);

    //Page<ReservationDTO> toReservationDTOsPage(Page<Reservation> reservations);
}
