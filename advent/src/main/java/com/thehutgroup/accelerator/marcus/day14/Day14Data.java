package com.thehutgroup.accelerator.marcus.day14;

import com.thehutgroup.accelerator.marcus.data.Data;
import com.thehutgroup.accelerator.marcus.day11.DataOutOfBoundsException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Day14Data extends Data {

    public Day14Data(String input) throws IOException {
        super(input);
    }

    public Day14Data(Data data) {
        super(data.getGrid());
    }

    private boolean canSlideNorth(Data tilt, Integer i, Integer j) {
//        System.out.println(super.getItemAt(i, j));
        if (Objects.equals(tilt.getItemAt(i - 1, j), ".")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canSlideSouth(Data tilt, Integer i, Integer j) {
//        System.out.println(super.getItemAt(i, j));
        if (Objects.equals(tilt.getItemAt(i + 1, j), ".")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canSlideEast(Data tilt, Integer i, Integer j) {
//        System.out.println(super.getItemAt(i, j));
        if (Objects.equals(tilt.getItemAt(i, j + 1), ".")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canSlideWest(Data tilt, Integer i, Integer j) {
//        System.out.println(super.getItemAt(i, j));
        if (Objects.equals(tilt.getItemAt(i, j - 1), ".")) {
            return true;
        } else {
            return false;
        }
    }

    public Integer getLoadSums() throws DataOutOfBoundsException {
        int weights = 0;
        for (int i = 0; i < super.getColumnSize(); i++) {
            int tot = 0;
            for (String j : super.getGrid().get(i)) {
                if (j.equals("O")) {
                    tot += 1;
                }
            }
            weights += tot * (super.getColumnSize() - i);
        }
        return weights;
    }

    public Data slideNorth(Data data, int i, int j) {
        data = data.changeData(i - 1, j, "O");
//        System.out.println(data.getColumnSize());
        data = data.changeData(i, j, ".");
        return data;
    }

    public Data slideSouth(Data data, int i, int j) {
        data = data.changeData(i + 1, j, "O");
//        System.out.println(data.getColumnSize());
        data = data.changeData(i, j, ".");
        return data;
    }

    public Data slideWest(Data data, int i, int j) {
        data = data.changeData(i, j - 1, "O");
//        System.out.println(data.getColumnSize());
        data = data.changeData(i, j, ".");
        return data;
    }

    public Data slideEast(Data data, int i, int j) {
        data = data.changeData(i, j + 1, "O");
//        System.out.println(data.getColumnSize());
        data = data.changeData(i, j, ".");
        return data;
    }


    public Day14Data tiltDataNorth(String direction) throws DataOutOfBoundsException {
        Data tiltData = new Data(getGrid());
        for (int i = super.getColumnSize() - 1; i > 0; i--) {
            for (int j = 0; j < super.getRowSize(); j++) {
//                System.out.println(i +" :" + j);
                if (Objects.equals(tiltData.getItemAt(i, j), "O")) {
                    if (Objects.equals(direction, "North")) {
                        if (canSlideNorth(tiltData, i, j)) {
                            tiltData = slideNorth(tiltData, i, j);
                        }
                    }
                }
            }
        }
        return new Day14Data(tiltData);
    }

    public Day14Data tiltDataWest(String direction) throws DataOutOfBoundsException {
        Data tiltData = new Data(getGrid());
        for (int j = super.getRowSize() - 1; j > 0; j--) {
            for (int i = 0; i < super.getColumnSize(); i++) {
//                System.out.println(i +" :" + j);
                if (Objects.equals(tiltData.getItemAt(i, j), "O")) {
                    if (Objects.equals(direction, "West")) {
                        if (canSlideWest(tiltData, i, j)) {
                            tiltData = slideWest(tiltData, i, j);
                        }
                    }
                }
            }
        }
        return new Day14Data(tiltData);
    }

    public Day14Data tiltDataEast(String direction) throws DataOutOfBoundsException {
        Data tiltData = new Data(getGrid());
        for (int j = 0; j < super.getRowSize() - 1; j++) {
            for (int i = 0; i < super.getColumnSize(); i++) {
//                System.out.println(i +" :" + j);
                if (Objects.equals(tiltData.getItemAt(i, j), "O")) {
                    if (Objects.equals(direction, "East")) {
                        if (canSlideEast(tiltData, i, j)) {
                            tiltData = slideEast(tiltData, i, j);
                        }
                    }
                }
            }
        }
        return new Day14Data(tiltData);
    }

    public Day14Data tiltDataSouth(String direction) throws DataOutOfBoundsException {
        Data tiltData = new Data(getGrid());
        for (int i = 0; i < super.getColumnSize() - 1; i++) {
            for (int j = 0; j < super.getRowSize(); j++) {
//                System.out.println(i +" :" + j);
                if (Objects.equals(tiltData.getItemAt(i, j), "O")) {
                    if (Objects.equals(direction, "South")) {
                        if (canSlideSouth(tiltData, i, j)) {
                            tiltData = slideSouth(tiltData, i, j);
                        }
                    }
                }
            }
        }
        return new Day14Data(tiltData);
    }


    public Day14Data fullTilt(String direction) throws DataOutOfBoundsException {
        if(Objects.equals(direction, "North")){
            Day14Data dR = tiltDataNorth(direction);
            for (int i = 0; i < 100; i++){
                dR = dR.tiltDataNorth(direction);
            }
            return dR;
        } else if (Objects.equals(direction, "South")){
            Day14Data dR = tiltDataSouth(direction);
            for (int i = 0; i < 100; i++){
                dR = dR.tiltDataSouth(direction);
            }
            return dR;
        }else if (Objects.equals(direction, "East")){
            Day14Data dR = tiltDataEast(direction);
            for (int i = 0; i < 100; i++){
                dR = dR.tiltDataEast(direction);
            }
            return dR;
        } else if (Objects.equals(direction, "West")){
            Day14Data dR = tiltDataWest(direction);
            for (int i = 0; i < 100; i++){
                dR = dR.tiltDataWest(direction);
            }
            return dR;
        } else{
            return null;
        }

    }
}