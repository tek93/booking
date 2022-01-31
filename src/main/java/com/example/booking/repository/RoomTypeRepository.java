package com.example.booking.repository;

import com.example.booking.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface RoomTypeRepository  extends JpaRepository<RoomType, Integer> {
    RoomType findByName(String name);

}
