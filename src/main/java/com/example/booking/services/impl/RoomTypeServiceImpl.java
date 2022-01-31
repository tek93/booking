package com.example.booking.services.impl;

import com.example.booking.model.RoomType;
import com.example.booking.repository.RoomTypeRepository;
import com.example.booking.services.RoomTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeRepository roomTypeRepository;
    @Override
    public RoomType findByName(String name) {
        return roomTypeRepository.findByName(name);
    }
}
