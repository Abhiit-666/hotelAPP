package com.example.hotelapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelapp.DTO.Foodinfo;
import com.example.hotelapp.DTO.OrderedItems;
import com.example.hotelapp.Service.Food.FoodServiceImplementation;

@RestController("/Menu")
public class FoodController {

    @Autowired
    FoodServiceImplementation foodServiceImplementation;

    FoodController(FoodServiceImplementation foodServiceImplementation){
        this.foodServiceImplementation=foodServiceImplementation;
    }

    @PostMapping("/getMenu")
    public List<Foodinfo> getMenu(@RequestBody String type){
        List<Foodinfo> FoodList=foodServiceImplementation.getList(type);
        return FoodList;

    }

    @PostMapping("/setOrder")
    public String OrderFood(@RequestBody List<OrderedItems> items){
        return "Order successful";
    }
    
}
