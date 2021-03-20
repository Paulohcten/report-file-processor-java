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

    public static void readFile(String inPath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inPath))) {
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
                        saleData.add(new Sale(fields[1], fields[3]));
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
                        throw new IllegalStateException("Unexpected value: " + fields[0] + "is not a valid code.");
                }
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int countClients() {
        int cont = 0;
        for (int i = 0; i < clientData.size(); i++) {
            cont++;
        }
        return cont;
    }

    public static int countSellers() {
        int cont = 0;
        for (int i = 0; i < sellerData.size(); i++) {
            cont++;
        }
        return cont;
    }

    public static List<Double> item1TotalValue() {
        double item1TotalPrice;
        List<Double> listItems1 = new ArrayList<>();
        for (Item data : saleItem1) {
            double quantity = Double.parseDouble(data.getQuantity());
            double price = Double.parseDouble(data.getPrice());
            item1TotalPrice = quantity * price;
            listItems1.add(item1TotalPrice);
        }
        return listItems1;
    }

    public static List<Double> item2TotalValue() {
        double item2TotalPrice;
        List<Double> listItems2 = new ArrayList<>();
        for (Item data : saleItem2) {
            double quantity = Double.parseDouble(data.getQuantity());
            double price = Double.parseDouble(data.getPrice());
            item2TotalPrice = quantity * price;
            listItems2.add(item2TotalPrice);
        }
        return listItems2;
    }

    public static List<Double> item3TotalValue() {
        double item3TotalPrice;
        List<Double> listItems3 = new ArrayList<>();
        for (Item data : saleItem3) {
            double quantity = Double.parseDouble(data.getQuantity());
            double price = Double.parseDouble(data.getPrice());
            item3TotalPrice = quantity * price;
            listItems3.add(item3TotalPrice);
        }
        return listItems3;
    }

    public static List<Double> SaleTotalValue() {
        List<Double> listItems1 = item1TotalValue();
        List<Double> listItems2 = item2TotalValue();
        List<Double> listItems3 = item3TotalValue();
        List<Double> totalList = new ArrayList<>();
        for (int i = 0; i < listItems1.size(); i++) {
            totalList.add(listItems1.get(i) + listItems2.get(i) + listItems3.get(i));
        }
        return totalList;
    }

    public static String bestSaleId() {
        List<Double> allSales = SaleTotalValue();
        double bestPrice = 0;
        int bestPricePosition = 0;
        for (int i = 0; i < allSales.size(); i++) {
            if (allSales.get(i) > bestPrice) {
                bestPrice = allSales.get(i);
                bestPricePosition = i;
            }
        }
        return saleData.get(bestPricePosition).getSaleId();
    }

    public static String worstSeller(){
        double worstSale=updateSellerSales().get(0).getTotalValue();
        String worstSeller=updateSellerSales().get(0).getSellerName();
        for (int i = 1; i <updateSellerSales().size(); i++) {
            if (updateSellerSales().get(i).getTotalValue() < worstSale){
                worstSeller=updateSellerSales().get(i).getSellerName();
            }
        }
        return worstSeller;
    }

    public static List<Sale> updateSellerSales(){
        List<Sale> sellersSales = new ArrayList<>();
        List<Sale> sellersTotalSale = new ArrayList<>();
        List<Double> allSales = SaleTotalValue();
        for(int i=0; i<saleData.size();i++){
            sellersSales.add(new Sale(saleData.get(i).getSellerName(),allSales.get(i)));
        }
        double sumValues;
        int j=0;
        sellersTotalSale.add(new Sale(sellersSales.get(0).getSellerName(),sellersSales.get(0).getTotalValue()));
        for (int i=1; i<sellersSales.size();i++){
            if(!sellersSales.get(i).getSellerName().equals(sellersTotalSale.get(j).getSellerName())){
                sellersTotalSale.add(sellersSales.get(i));
                j++;
            }
            else {
                sumValues = sellersTotalSale.get(j).getTotalValue()+sellersSales.get(i).getTotalValue();
                sellersTotalSale.get(j).setTotalValue(sumValues);
            }
        }
        return sellersTotalSale;
    }

    public static void clearLists(){
        sellerData.clear();
        clientData.clear();
        saleData.clear();
        saleItem1.clear();
        saleItem2.clear();
        saleItem3.clear();
    }
}