package com.thehutgroup.accelerator.marcus.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
//    private String inputData;
    private List<List<String>> data;

    public List<List<String>> getData() {
        return data;
    }

    Data(String input) throws IOException {
        data = importData(input);
    }

    private List<List<String>> importData(String input) throws IOException {
        List<String> rawData = Files.readAllLines(Path.of(input));
        List<List<String>> finalData = new ArrayList<>();
        for (String i : rawData){
            finalData.add(new ArrayList<>(Arrays.asList( i.split(""))));
        }
        return finalData;
    }

    public List<String> getRow (Integer index) throws DataOutOfBoundsException{
        if (index > data.size()){
            throw new DataOutOfBoundsException("Index too large");
        }
        return data.get(index);
    }

    public String getElement (Integer row, Integer element) throws DataOutOfBoundsException{
        System.out.println(row + " " + data.size());
        if (row > data.size()){
            System.out.println(data.size());
        }
        if (row > data.size() || element > data.get(row).size()){
            throw new DataOutOfBoundsException("Index too large");
        } else if (row < 0 || element < 0){
            throw new DataOutOfBoundsException("Index cannot be negative");
        }
        return data.get(row).get(element);
    }
}
