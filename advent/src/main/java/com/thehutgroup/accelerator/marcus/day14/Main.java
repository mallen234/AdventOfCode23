package com.thehutgroup.accelerator.marcus.day14;

import com.thehutgroup.accelerator.marcus.data.Data;
import com.thehutgroup.accelerator.marcus.day11.DataOutOfBoundsException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, DataOutOfBoundsException {
        Day14Data day14 = new Day14Data("./src/main/resources/input14.txt");
        Day14Data day14test = new Day14Data("./src/test/resources/test_14_1_q.txt");

        Day14Data testCycle1 = new Day14Data("./src/main/resources/day14_test_1_cycle");
        Day14Data testCycle2 = new Day14Data("./src/main/resources/day14_test_2_cycle");
        Day14Data testCycle3 = new Day14Data("./src/main/resources/day14_test_3_cycle");

//        System.out.println("cycle 1" + testCycle1.getLoadSums());
//        System.out.println("cycle 2" + testCycle2.getLoadSums());
//        System.out.println("cycle 3" + testCycle3.getLoadSums())

        List<Integer> sequence = new ArrayList<>();

        for(int i =0; i < 300; i++){
            day14 = test(day14);
            sequence.add(day14.getLoadSums());
            if (i % 50 == 0){
                System.out.println(i);
            }

        }
        System.out.println(sequence);
    }

    public static Day14Data test(Day14Data day14) throws DataOutOfBoundsException {
        Day14Data dR = day14.fullTilt("North");
//        dR.print();
//        System.out.println(dR.getLoadSums());

        dR = dR.fullTilt("West");
//        dR.print();

//        System.out.println(dR.getLoadSums());

        dR = dR.fullTilt("South");
//        dR.print();

//        System.out.println(dR.getLoadSums());

        dR = dR.fullTilt("East");
//        dR.print();

//        System.out.println(dR.getLoadSums());

        return dR;
    }
}
