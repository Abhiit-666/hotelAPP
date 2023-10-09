package com.example.hotelapp.Controller;

import java.time.LocalDate;
import java.util.Date;

import org.apache.el.parser.AstValue;
import org.glassfish.jaxb.core.Locatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelapp.DTO.Availability;
import com.example.hotelapp.Entity.Booking;
import com.example.hotelapp.Service.Booking.HotelServiceImplementation;

@RestController("/Booking")
public class BookingController {

    @Autowired
    HotelServiceImplementation hotelServiceImplementation;

    BookingController(HotelServiceImplementation hotelServiceImplementation) {
        this.hotelServiceImplementation = hotelServiceImplementation;
    }

    @PostMapping("/availability")
    public Availability available(@RequestBody Date checkInDate, @RequestBody Date checkOutDate) {
        Availability availability = new Availability();
        availability = hotelServiceImplementation.available(null, null);
        return availability;
    }

    @PostMapping("/BookTheRoom")
    public Booking booktheroom(@RequestBody LocalDate checkInDate, @RequestBody LocalDate checkOutDate, @RequestBody String roomNum)
    {
        hotelServiceImplementation.book(checkInDate,checkOutDate,roomNum);
        return null;
    }

}
