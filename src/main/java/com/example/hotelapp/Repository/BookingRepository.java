package com.example.hotelapp.Repository;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
        // String sql = "Select count(*) from Room where isOccupied='false'";
        // int count = jdbcTemplate.queryForObject(sql, Integer.class);
        // if (count > 0) {
        //     String sql1 = "SELECT r from Room r WHERE r NOT IN(SELECT b.room from Booking b WHERE (:checkInDate BETWEEN b.checkInDate AND b.checkOutDate OR :checkOutDate BETWEEN b.checkInDate AND b.checkOutDate)) AND r.isOccupied=false ORDER BY r.id ASC";
        //     TypedQuery<Room> query = entityManager.createQuery(sql1, Room.class);
        //     query.setParameter("checkInDate", checkinDate);
        //     query.setParameter("checkOutDate", checkoutDate);
        //     query.setMaxResults(1);
        //     Room availableRoom = query.getSingleResult();
        //     String roomNumber = availableRoom.getRoomNumber();
        //     return roomNumber;
        // } else {
        //     return "No rooms available";
        // }

        //room available in a given time frame
        //fix queryForObject
        String sql="SELECT r.room_number from room r LEFT JOIN booking b on r.id = b.room_id AND (b.check_in_date BETWEEN ? AND ? OR b.check_out_date BETWEEN ? AND ?) WHERE b.id IS NULL AND r.is_occupied = 0 LIMIT 1";    
        RowMapper<String> roomNumberMapper=(rs,rowNum) -> rs.getString("room_number");

        try{
            String roomNumber= jdbcTemplate.queryForObject(sql,
             new Object[]{checkinDate,checkoutDate,checkinDate,checkoutDate},roomNumberMapper);
            return roomNumber;
        }catch(Exception e){
            return e.toString();
        }

    }

    //Book empty room
    public String booking(LocalDate checkInDate, LocalDate checkOutDate, String roomNum)
    {   
        try{
        String sql="insert INTO booking (check_in_date,check_out_date,room_id) VALUES (?,?, (SELECT id from room WHERE room_number = ?))";
        jdbcTemplate.update(sql,new Object[]{checkInDate, checkOutDate, roomNum});       

        String updateRoom= "UPDATE room SET is_occupied = b'1' WHERE room_number = ?";
        jdbcTemplate.update(updateRoom, roomNum);

        return "Room Booked successfully!!";
        }catch(Exception e){
            return e.toString();
        }
    } 
    
}
