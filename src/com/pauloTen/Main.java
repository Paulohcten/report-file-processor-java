package com.pauloTen;

import static com.pauloTen.FileManagment.Reader.*;

public class Main {

    public static void main(String[] args) {
        String path = "C:\\Users\\phcte\\data\\in\\example.dat";
        readFile(path);

        System.out.println("Quantity of clients: "+countClients());
        System.out.println("Quantity of seller: "+countSellers());
        System.out.println("item1 total price: "+item1TotalValue());
        System.out.println("item2 total price: "+item2TotalValue());
        System.out.println("item3 total price: "+item3TotalValue());
        System.out.println("Sale prices: "+SaleTotalValue());
    }
}
