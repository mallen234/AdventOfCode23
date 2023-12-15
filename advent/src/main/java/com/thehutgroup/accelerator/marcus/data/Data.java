package com.thehutgroup.accelerator.marcus.data;

import com.thehutgroup.accelerator.marcus.day11.DataOutOfBoundsException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    //    private String inputData;
    private List<List<String>> data;

//    public List<List<String>> getData() {
//        return data;
//    }

    public String getItemAt(int x, int y){
        return data.get(x).get(y);
    }

    public Integer getRowSize(){
        return data.get(0).size();
    }

    public Integer getColumnSize(){
        return data.size();
    }

    public List<List<String>> getGrid(){
        List<List<String>> copyData = new ArrayList<>();
        for (List<String> innerList : data) {
            List<String> innerCopy = new ArrayList<>(innerList);
            copyData.add(innerCopy);
        }
        return copyData;
    }

    public Data changeData (int i,int j, String newVal){
        List<List<String>> copyData = new ArrayList<>();
        for (List<String> innerList : data) {
            List<String> innerCopy = new ArrayList<>(innerList);
            copyData.add(innerCopy);
        }
        copyData.get(i).set(j,newVal);
//        System.out.println(copyData);
        return new Data(copyData);
    }

    public Data(String input) throws IOException {
        data = importData(input);
    }

    public Data(List<List<String>> data) {
        this.data = data;
    }


    private List<List<String>> importData(String input) throws IOException {
        List<String> rawData = Files.readAllLines(Path.of(input));
        List<List<String>> finalData = new ArrayList<>();
        for (String i : rawData){
            finalData.add(new ArrayList<>(Arrays.asList( i.split(""))));
        }
        return finalData;
    }

    public List<String> getRow (Integer index) throws DataOutOfBoundsException {
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

//    @Override
    public boolean equals(Data data2) {
        if (data2.getGrid().equals(getGrid())){
            return true;

        } else{
            return false;
        }

    }

    public void print() throws DataOutOfBoundsException {
        for (int i = 0; i < this.getColumnSize();i++ ){
            System.out.println(getRow(i));
        }
    }
}

