package com.example.booking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
