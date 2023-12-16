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

        HashMap<Integer,Integer> emptyRows = new HashMap<>();

        Galaxy myGalaxy = new Galaxy("input11.txt");

        Data galaxyData = myGalaxy.getGalaxyData();

        System.out.println(galaxyData.getGrid());
    }
}
