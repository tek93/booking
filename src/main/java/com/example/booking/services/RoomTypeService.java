package com.example.booking.services;

import com.example.booking.model.RoomType;



public interface RoomTypeService  {
    RoomType findByName(String name);

}
