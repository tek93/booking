package com.example.booking.controllers;

import com.example.booking.dto.ConvertReservation;
import com.example.booking.dto.ReservationDto;
import com.example.booking.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private ConvertReservation convertReservation;

    @PostMapping("/reserved")
    public ResponseEntity create(@RequestBody @Valid ReservationDto request) {
        if (reservationService.checkAvailable(request.getStartDate(), request.getEndDate(), request.getRoomType()) != null) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.CONFLICT).body("This date in reserved");
        }

        return new ResponseEntity(reservationService.save(request), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody @Valid ReservationDto requestDto) throws Exception {
        try {

            return new ResponseEntity(reservationService.update(requestDto), HttpStatus.CREATED);
        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("the place is occupied on this day! or the booking ID does not exist");
        }


    }
    @GetMapping("/guest")
    public List<ReservationDto> reservationListForGuest(@RequestParam String guest){
        return reservationService.findAllByGuest(guest);

    }
    @GetMapping("/renter")
    public List<ReservationDto> reservationListForRenter(@RequestParam String renter){
        return reservationService.findAllByRenter(renter);

    }
    @GetMapping("/roomType")
    public List<ReservationDto> reservationListForRoomType(@RequestParam String roomType){
        return reservationService.findAllByRoomType(roomType);

    }



}
