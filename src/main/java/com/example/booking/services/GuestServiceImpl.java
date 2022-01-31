package com.example.booking.services;

import com.example.booking.model.Guest;
import com.example.booking.repository.GuestRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {


  private   GuestRepository guestRepository;

    @Override
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }
}
