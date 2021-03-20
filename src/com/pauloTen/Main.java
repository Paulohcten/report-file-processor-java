package com.pauloTen;


import java.io.File;
import java.io.FileNotFoundException;

import static com.pauloTen.FileManagment.Reader.clearLists;
import static com.pauloTen.FileManagment.Reader.readFile;
import static com.pauloTen.FileManagment.Writer.writeFile;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        while (true) {
            try {
                String homePath = System.getenv("HOMEPATH");
                String mainPath = homePath + "\\data";
                String pathOutDir = mainPath + "\\out";
                File file = new File(pathOutDir);
                boolean bool = file.mkdir();

                String inPath = mainPath + "\\in\\example.dat";
                readFile(inPath);

                String outPath = pathOutDir + "\\exampleOut.done.dat";
                writeFile(outPath);

                clearLists();

                try {
                    Thread.sleep(10000);//Raed the list again after 10 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException(e.getMessage());
            }
        }


    }
}