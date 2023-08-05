package com.example.hotelapp.Repository;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookingRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // check for empty rooms
    public String available(LocalDate checkinDate) {

        String sql = "Select count(*) from Room where isOccupied='false'";

        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        if (count > 0) {
            String sql1 = "Select roomNumber from Room where isOccupied='false' LIMIT 1";
            String roomNumber = jdbcTemplate.queryForObject(sql1, String.class);
            return roomNumber;
        } else {
            return "No rooms available";
        }
    }

}
