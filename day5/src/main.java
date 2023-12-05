import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class main {
    public static List<Long> getNumbersInPart2(List<Long> inputNumbers){
        for (int i=0;i<inputNumbers)
    }
    public static List<Long> parseStringArrayToLongArray(String[] stringArray) {
        int length = stringArray.length;
        Long[] longArray = new Long[length];

        for (int i = 0; i < length; i++) {
            longArray[i] = Long.parseLong(stringArray[i]);
        }
        return Arrays.asList(longArray);
    }


    public Long minimiseSeedInput(Long start, Long total, List<List<String>> listOfData ) {

        List<Long> locations = new ArrayList<>();
        for (long seed = start; seed < start + total; start++) {
            for (List<String> s : listOfData) {

                long map = 0L;
                boolean hit = false;
                for (String a : s) {
                    List<Long> source = parseStringArrayToLongArray(a.split(" "));
                    if (seed >= source.get(1) & seed < (source.get(1) + source.get(2))) {
                        hit = true;
                        map = seed - (source.get(1) - source.get(0));
                    }
                }
                if (hit) {
                    seed = map;
                }
                System.out.println("---");
            }
            locations.add(seed);
        }
        return Collections.min(locations);
    }

    public static void main(String[] args) throws IOException {

        List<List<String>> listOfData = new ArrayList<List<String>>();
        int i = 0;

//        List<Long> initialSeeds = new ArrayList<Long>(Arrays.asList(3127166940L, 109160474L, 3265086325L, 86449584L, 1581539098L ,205205726L, 3646327835L, 184743451L,2671979893L, 17148151L, 305618297L, 40401857L, 2462071712L, 203075200L, 358806266L, 131147346L, 1802185716L, 538526744L, 635790399L, 705979250L));
        List<Long> initialSeeds = new ArrayList<Long>(Arrays.asList(79L, 14L, 55L, 13L));

        List<String> lines = Files.readAllLines(Path.of("input.txt"));
        for (int j = 0, k = 1; j < lines.size(); j++){
            if (Objects.equals(lines.get(j), "")){
                listOfData.add(lines.subList(k,j));
                k = j+2;
            }
        }
        System.out.println(listOfData);

        List<Long> locations = new ArrayList<>();

        for (Long seed : initialSeeds){
            System.out.println(seed);
            for (List<String> s: listOfData){

                Long map = 0L;
                boolean hit = false;
                for (String a: s) {
                    List<Long> source = parseStringArrayToLongArray(a.split(" "));
                    if (seed >= source.get(1) & seed < (source.get(1) + source.get(2))) {
                        hit = true;
                        if (seed == 53 || seed ==14){

                            System.out.printf("%d || %d || %d || %d\n",source.get(0),source.get(1) ,source.get(2), seed);
                            map = seed - (source.get(1) - source.get(0));
                            System.out.println(map);
                        }
//                        System.out.println(seed);

                        map = seed - (source.get(1) - source.get(0));
//                        System.out.println(map);
                    }
                }
                if (hit){
                    seed = map;
                }
                System.out.println("---");
//                System.out.println(seed);


            }
            System.out.println();
            locations.add(seed);

        }
//        System.out.println(initialSeeds);

        System.out.println(locations);

        System.out.println(Collections.min(locations));








    }
}
