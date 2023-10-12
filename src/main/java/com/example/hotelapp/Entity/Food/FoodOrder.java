package com.example.hotelapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private double price;
    private Boolean veg;


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    
    /**
     * @return Boolean return the veg
     */
    public Boolean isVeg() {
        return veg;
    }

    /**
     * @param veg the veg to set
     */
    public void setVeg(Boolean veg) {
        this.veg = veg;
    }

    @Override
    public String toString() {
        return "FoodOrder [id=" + id + ", itemName=" + itemName + ", price=" + price + ", veg=" + veg + "]";
    }

    
   



}
