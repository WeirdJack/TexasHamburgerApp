package com.bhargav.texashamco.service;

import com.bhargav.texashamco.dto.ReservationDTO;
import com.bhargav.texashamco.mapper.ReservationMapper;
import com.bhargav.texashamco.models.Reservation;
import com.bhargav.texashamco.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    ReservationMapper reservationMapper;

    public List<ReservationDTO> getAllReservations(){

        return reservationMapper.toReservationDTOs(reservationRepository.findAll());
    }

    public Page<Reservation> getReservationsByPage(int pageNumber, int pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return reservationRepository.findAll(pageable);
    }

    public void addReservation(ReservationDTO reservationDTO) {

        reservationRepository.insert(reservationMapper.toReservation(reservationDTO));
    }

    public void updateReservation(ReservationDTO reservationDTO) {

        Reservation reservation = reservationMapper.toReservation(reservationDTO);
        Reservation existing = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Reservation with ID: " + reservation.getId())
                ));

        existing.setId(reservation.getId());
        reservationRepository.save(existing);
    }

    public void deleteReservation(ReservationDTO reservationDTO) {

        Reservation reservation = reservationMapper.toReservation(reservationDTO);
        Reservation existing = reservationRepository.findById(reservation.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find Reservation with ID: " + reservation.getId())
                ));

        reservationRepository.delete(existing);
    }
}
