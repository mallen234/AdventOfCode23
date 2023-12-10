package day9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class main {
    public static boolean isZeros(List<Integer> sequence){
        for (Integer i : sequence){
            if (i != 0){
                return false;
            }
        }
        return true;
    }

    public static Integer findNextValueInSeries(String[] data){
        List<Integer> ogSeq = new ArrayList<>();
        List<Integer> newSeq = new ArrayList<>();
        for (String s : data) {
            ogSeq.add(Integer.valueOf(s));
        }
        Deque<List<Integer>> allSequences = new ArrayDeque<>();
        allSequences.add(ogSeq);

        while (!isZeros(ogSeq)) {
//            System.out.println(ogSeq);
            for (int i = 1; i < ogSeq.size(); i++) {
                Integer prev = ogSeq.get(i - 1);
                Integer curr = ogSeq.get(i);
                newSeq.add(curr - prev);
            }
            ogSeq = new ArrayList<>(newSeq);
            allSequences.addFirst(ogSeq);

            newSeq.clear();
        }
        Integer finalVal = 0;
        for (List<Integer> seq : allSequences) {
            finalVal =  allSequences.removeFirst().getFirst() -  finalVal;
        }
        System.out.println(finalVal);
        return finalVal;
    }

    public static void main(String[] args) throws IOException {
        List<String> data1 = Files.readAllLines(Path.of("input9.txt"));

        for (String seq : data1){
            String[] seqData =  seq.split(" ");
//            System.out.println(Arrays.toString(seqData));
        }

        File input = new File("./input9.txt");
        Scanner scan = new Scanner(input);

        List<String[]> data = new ArrayList<>();

        while (scan.hasNextLine()){
            data.add(scan.nextLine().split(" "));
        }

//        System.out.println(findNextValueInSeries(data.get(2)));

        int tot = 0;
        for (String[] currSequence : data ) {
            tot += findNextValueInSeries(currSequence);
        }
        System.out.println(tot);
    }
}
