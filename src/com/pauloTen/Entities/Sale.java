package com.pauloTen.Entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sale implements Serializable {

    private static final Integer id =3;
    private String saleId;
    private String sellerName;
    private Double totalValue;

    private List<Item> items = new ArrayList<>();

    public Sale(){
    }

    public Sale(String sellerName, Double totalValue) {
        this.sellerName = sellerName;
        this.totalValue = totalValue;
    }

    public Sale(String saleId, String sellerName) {
        this.saleId = saleId;
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

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return  sellerName +
                " totalValue=" + totalValue;
    }
}
