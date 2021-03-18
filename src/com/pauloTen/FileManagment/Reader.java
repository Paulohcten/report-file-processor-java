package com.pauloTen.FileManagment;

import com.pauloTen.Entities.Client;
import com.pauloTen.Entities.Item;
import com.pauloTen.Entities.Sale;
import com.pauloTen.Entities.Seller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private static List<Client> clientData = new ArrayList<>();
    private static List<Seller> sellerData = new ArrayList<>();
    private static List<Sale> saleData = new ArrayList<>();
    private static List<Item> saleItem1 = new ArrayList<>();
    private static List<Item> saleItem2 = new ArrayList<>();
    private static List<Item> saleItem3 = new ArrayList<>();

    public static void readFile(String path){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] fields = line.split("ç");
                switch (fields[0]) {
                    case "001":
                        sellerData.add(new Seller(fields[1], fields[2], fields[3]));
                        break;

                    case "002":
                        clientData.add(new Client(fields[1], fields[2], fields[3]));
                        break;

                    case "003":
                        fields[2] = fields[2].substring(1, fields[2].length() - 1);
                        String[] parts = fields[2].split(",");
                        String[] data1 = parts[0].split("-");
                        String[] data2 = parts[1].split("-");
                        String[] data3 = parts[2].split("-");
                        saleItem1.add(new Item(data1[0], data1[1], data1[2]));
                        saleItem2.add(new Item(data2[0], data2[1], data2[2]));
                        saleItem3.add(new Item(data3[0], data3[1], data3[2]));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + fields[0]+ "is not a valid code.");
                }
                line = bufferedReader.readLine();
            }
            System.out.println("Sellers: ");
            for (Seller data : sellerData) {
                System.out.println(data.getName() + "/" + data.getCPF() + "/" + data.getSalary());
            }
            System.out.println();
            System.out.println("Clients: ");
            for (Client data : clientData) {
                System.out.println(data.getName() + "/" + data.getCNPJ() + "/" + data.getBusinessArea());
            }
            System.out.println();
            System.out.println(" Items of Sales: ");
            for (Item data : saleItem1) {
                System.out.println(data.getId() + "/" + data.getQuantity() + "/" + data.getPrice() + "\n");
            }
            for (Item data : saleItem2) {
                System.out.println(data.getId() + "/" + data.getQuantity() + "/" + data.getPrice() + "\n");
            }
            for (Item data : saleItem3) {
                System.out.println(data.getId() + "/" + data.getQuantity() + "/" + data.getPrice() + "\n");
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
