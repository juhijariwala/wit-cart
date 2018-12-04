package com.wit.cart.witcart.model;

public class Item {
    private String name;
    private int id;
    private String description;
    private float price;

    @Override
    public String toString() {
        return this.name+" "+this.id+" "+this.description+" "+this.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

