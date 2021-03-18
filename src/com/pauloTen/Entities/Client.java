package com.pauloTen.Entities;
import java.io.Serializable;

public class Client implements Serializable {

    private static final Long id = 2L;
    private String CNPJ;
    private String name;
    private String businessArea;

    public Client(){
    }

    public Client(String CNPJ, String name, String businessArea) {
        this.CNPJ = CNPJ;
        this.name = name;
        this.businessArea = businessArea;
    }

    public static Long getId() {
        return id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }
}
