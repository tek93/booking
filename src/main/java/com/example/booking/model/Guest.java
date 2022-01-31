package com.example.booking.model;


import com.example.booking.model.Reservation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Guest {
    @Id

    @NotNull(message = "Filed name cannot be null!")
    private  String name;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Reservation> reservationList;


}
