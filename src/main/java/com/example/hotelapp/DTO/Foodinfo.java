package com.example.hotelapp.DTO;

public class Foodinfo {


    private String itemName;
    private double price;

    public Foodinfo(String itemName, double price){
        this.itemName=itemName;
        this.price=price;
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

}
