package com.pauloTen.Entities;
import java.io.Serializable;

public class Seller implements Serializable {

    private static final Integer id = 1;
    private String CPF;
    private String name;
    private String salary;

    public Seller() {
    }

    public Seller(String CPF, String name, String salary) {
        this.CPF = CPF;
        this.name = name;
        this.salary = salary;
    }

    public static Integer getId() {
        return id;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
