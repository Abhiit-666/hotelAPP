package com.example.hotelapp.Service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.example.hotelapp.DTO.Availability;
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

    public Availability available(LocalDate checkInDate, LocalDate checkOutDate) {
        String isavailable = bookingrepository.available(checkInDate, checkOutDate);
        Availability availability = new Availability();
        if (isavailable.equals("No rooms available")) {
            availability.setavail(false);
            availability.setRno(null);
        } else {
            availability.setavail(true);
            availability.setRno(isavailable);
        }
        return availability;
    }
}
