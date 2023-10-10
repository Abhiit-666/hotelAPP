package com.example.hotelapp.Service.Food;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hotelapp.DTO.Foodinfo;
import com.example.hotelapp.Repository.FoodOrderRepository;

@Service
public class FoodServiceImplementation implements FoodService{

    private final FoodOrderRepository foodOrderRepository;

    FoodServiceImplementation(FoodOrderRepository foodOrderRepository){
        this.foodOrderRepository=foodOrderRepository;
    }


    public List<Foodinfo> getList(String type){
        List<Foodinfo> foodList=new ArrayList<>();
        foodList=foodOrderRepository.foodSearch(type);
        return foodList;
    }
}
