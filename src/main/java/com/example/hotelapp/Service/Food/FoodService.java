package com.example.hotelapp.Service.Food;

import java.util.List;

import com.example.hotelapp.DTO.Foodinfo;
import com.example.hotelapp.DTO.OrderedItems;

public interface FoodService {

/* Generates a List of Food based on the given type
 * @param type; The type of food to search for
 * @return a List of available food of the give type
 */
    List<Foodinfo> getList(String type);

    /* Processes an Order for the given Ordereditems
     * @param items; items ordered
     * @return the status of the order.
     */
    String orderFood(List<OrderedItems> items);


}
