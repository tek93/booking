package com.example.booking.dto;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReservationDto {


    private Integer id;

    @NotNull(message = "Filed roomType cannot be null!")
    private String  roomType;

    @NotNull(message = "Filed Guest cannot be null!")
    private String guest;
    @NotNull(message = "Filed Renter cannot be null!")
    private String renter;
    private BigDecimal cost;

    @NotNull(message = "Start rent cannot be null!")
    private LocalDate startDate;

    @NotNull(message = "Finish rent cannot be null!")
    private LocalDate endDate;






}
