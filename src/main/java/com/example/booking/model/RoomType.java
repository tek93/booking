package com.example.booking.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class RoomType {
   @Id
   @NotNull
   private String name;
   @NotNull
   private  BigDecimal price;
   @NotNull
   private Integer roomArea;
   @NotNull
   private String description;
   @OneToMany
   @JoinColumn(name = "id")
   private List<Reservation> reservationList;



}
