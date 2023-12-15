package com.thg.accelerator.marcus;

import com.thehutgroup.accelerator.marcus.data.Data;
import com.thehutgroup.accelerator.marcus.day14.Day14Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Test {
    private Day14Data testFile;
    private Data solFile;

    @BeforeEach
    public void setUp() {
        try {
            testFile = new Day14Data( "./src/test/resources/test_14_1_q.txt");
            solFile = new Day14Data("./src/test/resources/test_14_1_sol.txt");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    //    @ParameterizedTest(name = "FizzBuzz prints normal numbers - {0}")
//    @ValueSource(MarkdownFile = new MarkdownFile(""))
    @Test
    public void TestGetLengthofFile(){
        testFile =  testFile.tiltData();
        assertEquals(testFile.getGrid(), solFile.getGrid());
    }

    }