package com.example;
public class Item {
    private String itemId;
    private double price;
    private String description;
    private String title;

    public Item(String itemId, double price, String description, String title) {
        this.itemId = itemId;
        this.price = price;
        this.description = description;
        this.title = title;
    }

    public String getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + ", Title: " + title + ", Price: " + price + ", Description: " + description;
    }
}
