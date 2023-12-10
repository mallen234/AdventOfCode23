import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static List<Character> traverseString(String str) {
        List<Character> splitStr = new ArrayList<>();

        CharacterIterator it = new StringCharacterIterator(str);
        // Iterate and print current character
        while (it.current() != CharacterIterator.DONE) {
            splitStr.add(it.current());
            it.next();
        }
        return splitStr;
    }

    public static String getFinalStrElement(String str){
        return str.substring(str.length()-1);
    }

    public static boolean checkIfFinalAreZ(List<String> positions){
        for (String pos : positions){
            if (getFinalStrElement(pos) != "Z"){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        List<String> data = Files.readAllLines(Path.of("input.txt"));
        List<String> maps = (data.subList(2, data.size()));

        HashMap<Character,Integer> dirMap = new HashMap<>();
        dirMap.put('L',0);
        dirMap.put('R',1);

        List<Character> directions = traverseString(data.get(0));
//        System.out.println(directions);
        HashMap<String,List<String>> camelMap = new HashMap<>();



        for (String mapElement : maps){
            Pattern pattern = Pattern.compile("[A-Z]{3}");
            Matcher matcher = pattern.matcher(mapElement);
            List<String> newKey = new ArrayList<>();
            while (matcher.find()) {
                newKey.add(matcher.group());
            }
            camelMap.put(newKey.get(0),newKey.subList(1,3));
        }

        List<String> positions = new ArrayList<>();
        for (String pos: camelMap.keySet()){
            if (getFinalStrElement(pos).equals("A")){
                positions.add(pos);
            }
        }


        System.out.println(positions);
        int i = 0;
        while (!checkIfFinalAreZ(positions)){
//            List<String> updatedPositions = new ArrayList<>();
            for (int j = 0; j < positions.size(); j++){
                positions.set(j,camelMap.get(positions.get(j)).get(dirMap.get(directions.get((i % 271) ))));
            }

            System.out.println(positions);
//            pos = camelMap.get(pos).get(dirMap.get(directions.get((i % 271) )));
//            System.out.println(pos + ": "  + i);
            i++;
        }
        System.out.println(i);

//        System.out.println(camelMap);
    }
}
