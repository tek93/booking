package com.example.booking.repository;

import com.example.booking.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository  extends JpaRepository<Guest, Integer> {
}
