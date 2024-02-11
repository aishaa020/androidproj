package com.example.project.models;

public class Product
{
    int image ;
    String name;
    String description;
    String catagory;
    String price ;
    String quantity;
    String id;
    String status;

    public Product(int image, String name, String description, String catagory, String price, String quantity, String id, String status) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.catagory = catagory;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
        this.status = status;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
