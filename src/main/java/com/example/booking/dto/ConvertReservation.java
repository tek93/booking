package com.example.booking.dto;

import com.example.booking.model.Reservation;
import com.example.booking.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor

public class ConvertReservation {



        private ReservationRepository reservationRepository;
        public ReservationDto entityToDto(Reservation reservation){
            ReservationDto dto = new ReservationDto();
            dto.setId(reservation.getId());
            dto.setCost(reservation.getCost());
            dto.setEndDate(reservation.getEndDate());
            dto.setGuest(reservation.getGuest());
            dto.setRenter(reservation.getRenter());
            dto.setRoomType(reservation.getRoomType());
            dto.setStartDate(reservation.getStartDate());
            return dto;
        }
        public Reservation dtoToEntity(ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation.setId(reservationDto.getId());
        reservation.setCost(reservationDto.getCost());
        reservation.setEndDate(reservationDto.getEndDate());
        reservation.setGuest(reservationDto.getGuest());
        reservation.setRenter(reservationDto.getRenter());
        reservation.setRoomType(reservationDto.getRoomType());
        reservation.setStartDate(reservationDto.getStartDate());
        return reservation;

    }
        public List<ReservationDto> convertAllReservationForGuest(String guest){
            List<Reservation> reservations = reservationRepository.findAllByGuest(guest);
            return reservations.stream().map(x->entityToDto(x)).collect(Collectors.toList());
        }
        public List<ReservationDto> convertAllReservationForRenter(String renter){

        List<Reservation> reservations = reservationRepository.findAllByRenter(renter);
        return reservations.stream().map(x->entityToDto(x)).collect(Collectors.toList());

        }
        public List<ReservationDto> convertAllReservationForRoomType(String roomType){

        List<Reservation> reservations = reservationRepository.findAllByRoomType(roomType);
        return reservations.stream().map(x->entityToDto(x)).collect(Collectors.toList());


        }

    }
