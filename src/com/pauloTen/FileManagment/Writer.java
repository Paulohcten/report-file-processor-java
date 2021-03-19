package com.pauloTen.FileManagment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.pauloTen.FileManagment.Reader.*;

public class Writer {
    public static void writeFile(String outPath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {

            bw.write("Clients quantity: " +countClients());
            bw.newLine();
            bw.write("Sellers quantity: " +countSellers());
            bw.newLine();
            bw.write("Expensive Sale ID: " +bestSaleId());
            bw.newLine();
            bw.write("Worst seller name: " +worstSeller());

        }
        catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}



