package com.example.project.models;

public class ItemsModel {

    int img;
    String price;


    public ItemsModel(String price, int img) {
        this.img = img;
        this.price = price;
    }


    public int getImg() {
        return img;
    }

    public String getPrice() {
        return price;
    }
}
