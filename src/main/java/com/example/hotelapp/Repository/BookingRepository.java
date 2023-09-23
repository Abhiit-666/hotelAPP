package com.example.hotelapp.Repository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.hotelapp.Entity.Room;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.EntityManager;

public class BookingRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    private final EntityManager entityManager;

    BookingRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    // check for empty rooms
    public String available(LocalDate checkinDate, LocalDate checkoutDate) {

        //I should be checking the checkinDate and checkout date in the booking table. Instead of just isOccupied=false.
        //As the idea here is to have the room be associated with multiple bookings where isOccupied can vary based on the check IN/OUT dates.
        //Need to explore this a little
        String sql = "Select count(*) from Room where isOccupied='false'";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        if (count > 0) {
            String sql1 = "SELECT r from Room r WHERE r NOT IN(SELECT b.room from Booking b WHERE (:checkInDate BETWEEN b.checkInDate AND b.checkOutDate OR :checkOutDate BETWEEN b.checkInDate AND b.checkOutDate)) AND r.isOccupied=false ORDER BY r.id ASC";
            TypedQuery<Room> query = entityManager.createQuery(sql1, Room.class);
            query.setParameter("checkInDate", checkinDate);
            query.setParameter("checkOutDate", checkoutDate);
            query.setMaxResults(1);
            Room availableRoom = query.getSingleResult();
            String roomNumber = availableRoom.getRoomNumber();
            return roomNumber;
        } else {
            return "No rooms available";
        }

    }

    //Book empty room
    public String booking(LocalDate checkInDate, LocalDate checkOutDate, String roomNum)
    {
        String sql="Select id from room where room_number=?";
        String sql=

    } 
    return null;
}
