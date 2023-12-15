package com.thehutgroup.accelerator.marcus.day11;
import com.thehutgroup.accelerator.marcus.data.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world");
        Data data = null;
        try {
            data = new Data("./src/main/resources/input11.txt");
        } catch( IOException e){
            System.out.println("An IOException occurred: " + e.getMessage());
        }

        HashMap<Integer,Integer> emptyRows = new HashMap<>();
        try{
            System.out.println(data.getElement(200000,2));
        } catch (DataOutOfBoundsException e){
            System.out.println("INDEX ISSUE: " + e.getMessage());
        }

//        for (int i = 0; i < data.getData().size(); i++){
//            for (int j = 0; j < data.getData().get(i).size();j++){
//                try {
//                    if (data.getElement(i,j) == "#"){
//
//                    }
//                } catch (DataOutOfBoundsException e){
//                    System.out.println(e.getMessage());
//                }
//            }
//            System.out.println();
//        }


        for (List<String> a : data.getGrid()){
            System.out.println(a);
        }
//        System.out.println(data.getData());
    }
}
