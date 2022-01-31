package com.example.booking.repository;

import com.example.booking.dto.ReservationDto;
import com.example.booking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value =
            "SELECT id FROM reservation WHERE room_type = :type AND " +
                    "(:start BETWEEN start_date  AND  end_date  ) AND" +
                    " (:end BETWEEN  start_date  AND  end_date ) AND " +
                    "(:start <=  start_date  AND :end >=  end_date )", nativeQuery = true)
    Integer checkAvailable(@Param("start")LocalDate startDate , @Param("end") LocalDate endDate, @Param("type") String roomType);
    Reservation save(Reservation reservation);
    List<Reservation>findAllByGuest(String guest);
    List<Reservation> findAllByRenter(String renter);
    List<Reservation>findAllByRoomType(String roomType);



}
