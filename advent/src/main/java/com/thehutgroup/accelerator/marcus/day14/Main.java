package com.thehutgroup.accelerator.marcus.day14;

import com.thehutgroup.accelerator.marcus.data.Data;
import com.thehutgroup.accelerator.marcus.day11.DataOutOfBoundsException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, DataOutOfBoundsException {
        Day14Data day14 = new Day14Data("./src/main/resources/input14.txt");
        Day14Data day14test = new Day14Data("./src/test/resources/test_14_1_q.txt");

        Day14Data dR = day14.tiltData();


        for (int i = 0; i < 100000; i++){
            dR = dR.tiltData();
        }
//        System.out.println(dR.getLoadSums());
//        System.out.println(dR.getColumnSize());

    }
}
