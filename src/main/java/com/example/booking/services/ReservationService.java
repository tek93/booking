package com.example.booking.services;

import com.example.booking.dto.ReservationDto;
import com.example.booking.model.Reservation;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    Integer checkAvailable(LocalDate startDate , LocalDate endDate, String roomType);
    Reservation save(@Valid ReservationDto reservation);
    Reservation update(ReservationDto reservationDto) throws Exception;
    List<ReservationDto> findAllByGuest(String guest);
    List<ReservationDto> findAllByRenter(String renter);
    List<ReservationDto> findAllByRoomType(String roomType);
}
