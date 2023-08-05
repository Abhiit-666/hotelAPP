package com.example.hotelapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelapp.Repository.BookingRepository;
import com.example.hotelapp.Repository.FoodOrderRepository;
import com.example.hotelapp.Repository.RoomRepository;

@Service
public class HotelServiceImplementation {

    private final RoomRepository roomRepository;
    private final BookingRepository bookingrepository;
    private final FoodOrderRepository foodOrderRepository;

    @Autowired
    HotelServiceImplementation(RoomRepository roomRepository, BookingRepository bookingrepository,
            FoodOrderRepository foodOrderRepository) {
        this.roomRepository = roomRepository;
        this.bookingrepository = bookingrepository;
        this.foodOrderRepository = foodOrderRepository;
    }

}
