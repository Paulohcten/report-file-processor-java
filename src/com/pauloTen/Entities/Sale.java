package com.pauloTen.Entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sale implements Serializable {

    private static final Integer id =3;
    private String saleId;
    private List<Item> items = new ArrayList<>();
    private String sellerName;

    public Sale(){
    }

    public Sale(String saleId, List<Item> items, String sellerName) {
        this.saleId = saleId;
        this.items = items;
        this.sellerName = sellerName;
    }

    public static Integer getId() {
        return id;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
