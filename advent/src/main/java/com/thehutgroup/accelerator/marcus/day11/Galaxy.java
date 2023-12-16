package com.thehutgroup.accelerator.marcus.day11;

import com.thehutgroup.accelerator.marcus.data.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private Data galaxyData;

    public Data getGalaxyData() {
        return galaxyData;
    }

    public Galaxy(String input) throws IOException {
        galaxyData = new Data(input);
    }

    public Data expand(){
        List<List<String>> grid = galaxyData.getGrid()
        for (int i = 0; i < galaxyData.getColumnSize(); i ++){
            for (int j = 0; j < galaxyData.getColumnSize())
        }
    }

}
