package com.example.hotelapp.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.hotelapp.DTO.Foodinfo;

@Repository
public class FoodOrderRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate; 


    FoodOrderRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Foodinfo> foodSearch(String type){
        String sql="";
        List<Foodinfo> foodList= new ArrayList<>();
        if(type.equalsIgnoreCase("Veg"))
        {
             sql="Select itemName,price from food_order where veg = 1";
        }else{
             sql="Select itemName,price from food_order where veg = 0";
        }
        try{
        List<Map<String,Object>> rows= jdbcTemplate.queryForList(sql);

        for(Map<String,Object> row: rows){
            String itemName=(String)row.get("itemName");
            Double price=(Double)row.get("price");

            foodList.add(new Foodinfo(itemName,price));
        }
        return foodList;
    }catch(Exception e){
        return foodList;
    }
        
    }
}
