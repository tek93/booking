package com.example.booking.services.impl;

import com.example.booking.cost.CountCost;
import com.example.booking.dto.ConvertReservation;
import com.example.booking.dto.ReservationDto;
import com.example.booking.model.Reservation;
import com.example.booking.model.RoomType;
import com.example.booking.repository.ReservationRepository;
import com.example.booking.services.ReservationService;
import com.example.booking.services.RoomTypeService;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;



@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    private CountCost countCost;
    private RoomTypeService roomTypeService;
    private ConvertReservation convertReservation;

    @Override
    public Integer checkAvailable(LocalDate startDate, LocalDate endDate, String roomType) {
        return reservationRepository.checkAvailable(startDate, endDate, roomType);
    }

    @Override
    public Reservation save(ReservationDto reservationDto) {

        Reservation reservation=   convertReservation.dtoToEntity(reservationDto);
        countCost(reservation);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(ReservationDto reservationDto) throws Exception {

        Reservation reservation = reservationRepository.findById(reservationDto.getId()).orElseThrow();

        if (reservationRepository.existsById(reservation.getId())) {
            reservation =  reservation =  convertReservation.dtoToEntity(reservationDto);
            countCost(reservation);
        }
        else if ((checkAvailable(reservation.getStartDate(), reservation.getEndDate(), reservation.getRoomType()) != null) || !reservationRepository.existsById(reservation.getId())) {
            throw new Exception("the place is occupied on this date! or the booking ID does not exist");
        }
        return reservationRepository.save(reservation);
    }

    private void countCost(Reservation reservation) {
        RoomType byName = roomTypeService.findByName(reservation.getRoomType());
        BigDecimal cost = countCost.CountCost(reservation.getStartDate(), reservation.getEndDate(), byName.getPrice());
        reservation.setCost(cost);
    }

    @Override
    public List<ReservationDto> findAllByGuest(String guest) {
        return convertReservation.convertAllReservationForGuest(guest);
    }

    @Override
    public List<ReservationDto> findAllByRenter(String renter) {
        return convertReservation.convertAllReservationForRenter(renter);
    }

    @Override
    public List<ReservationDto> findAllByRoomType(String roomType) {
        return convertReservation.convertAllReservationForRoomType(roomType);
    }


}
