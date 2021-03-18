package com.pauloTen.Entities;
import java.io.Serializable;

public class Item extends Sale implements Serializable {

    private String id;
    private String quantity;
    private String price;

    public Item(){
    }

    public Item(String id, String quantity, String price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
