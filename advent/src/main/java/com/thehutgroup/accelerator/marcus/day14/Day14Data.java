package com.thehutgroup.accelerator.marcus.day14;

import com.thehutgroup.accelerator.marcus.data.Data;
import com.thehutgroup.accelerator.marcus.day11.DataOutOfBoundsException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Day14Data extends Data{

    public Day14Data(String input) throws IOException {
        super(input);
    }

    public Day14Data(Data data)  {
        super(data.getGrid());
    }

    private boolean canSlideNorth(Data tilt,Integer i ,Integer j){
//        System.out.println(super.getItemAt(i, j));
        if (Objects.equals(tilt.getItemAt(i-1, j), ".")){
            return true;
        } else{
            return false;
        }
    }

    public Integer getLoadSums() throws DataOutOfBoundsException {
        int weights = 0;

        for (int i = 0; i < super.getColumnSize(); i++){
            int tot = 0;
            for (String j : super.getGrid().get(i)){
                if (j.equals("O")){
                    System.out.print(1);
                    tot += 1;
                }
            }
            System.out.println("\n");
            weights += tot * (super.getColumnSize() - i);
            System.out.println(tot);
        }
        return weights;
    }

    public Data slideNorth(Data data, int i, int j){
        data =  data.changeData(i-1,j,"O");
//        System.out.println(data.getColumnSize());
        data =  data.changeData(i,j,".");
        return data;
    }

    public Day14Data tiltData() throws DataOutOfBoundsException {
        Data tiltData = new Data(getGrid());
        for (int i = super.getColumnSize() - 1; i > 0; i--){
            for (int j = 0; j < super.getRowSize(); j++){
//                System.out.println(i +" :" + j);
                if (Objects.equals(tiltData.getItemAt(i, j), "O")){
                    if (canSlideNorth(tiltData,i,j)){
                        tiltData = slideNorth(tiltData,i,j);
                    }
                }
            }
        }
        return new Day14Data(tiltData);
    }
}
