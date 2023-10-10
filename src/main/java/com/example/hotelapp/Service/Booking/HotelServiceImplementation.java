package com.example.hotelapp.Service.Booking;

import java.time.LocalDate;


import org.springframework.stereotype.Service;

import com.example.hotelapp.DTO.Availability;
import com.example.hotelapp.Repository.BookingRepository;

@Service
public class HotelServiceImplementation implements HotelService{

    
    private final BookingRepository bookingrepository;
    

    
    HotelServiceImplementation(BookingRepository bookingrepository) {
        
        this.bookingrepository = bookingrepository;
        
    }

    //Checking for the availability of rooms
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

    //Booking the room if available for the given time period
    public String book(LocalDate checkInDate, LocalDate checkOutDate, String roomNum)
    {
       try{
        bookingrepository.booking(checkInDate,checkOutDate,roomNum);
        return "Room booked for the chosen time";
       }catch(Exception e)
       {
           return e.toString();   
       }
    }

}
