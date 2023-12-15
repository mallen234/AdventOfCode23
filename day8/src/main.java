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
    public static HashMap<Character,Integer> dirMap = new HashMap<>();
    public static HashMap<String,List<String>> camelMap = new HashMap<>();
    public static List<Character> directions = new ArrayList<>();
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

    public static Integer findStepsToZ(String pos) {
        int i = 0;
        while (!getFinalStrElement(pos).equals("Z")) {
//            List<String> updatedPositions = new ArrayList<>();
//        for (int j = 0; j < position.size(); j++){
//            position.set(j,camelMap.get(position.get(j)).get(dirMap.get(direction.get((i % 271)))));
//        }

//            System.out.println(i);
            pos = camelMap.get(pos).get(dirMap.get(directions.get((i % 271))));
//            System.out.println(pos + ": " + i);
            i++;

        }
        return i;
    }
    public static boolean checkIfFinalAreZ (List <String> positions) {
        for (String pos : positions) {
            if (!getFinalStrElement(pos).equals("Z")) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[]args) throws IOException {
        List<String> data = Files.readAllLines(Path.of("input8.txt"));
        List<String> maps = (data.subList(2, data.size()));

        dirMap = new HashMap<>();
        dirMap.put('L', 0);
        dirMap.put('R', 1);

        directions = traverseString(data.get(0));
//        System.out.println(directions);
//        HashMap<String, List<String>> camelMap = new HashMap<>();


        for (String mapElement : maps) {
            Pattern pattern = Pattern.compile("[A-Z0-9]{3}");
            Matcher matcher = pattern.matcher(mapElement);
            List<String> newKey = new ArrayList<>();
            while (matcher.find()) {
                newKey.add(matcher.group());
            }
            camelMap.put(newKey.get(0), newKey.subList(1, 3));
        }

        List<String> positions1 = new ArrayList<>();
        List<String> positions = new ArrayList<>();
        for (String pos : camelMap.keySet()) {
            if (getFinalStrElement(pos).equals("A")) {
                positions.add(pos);
            }
        }

        List<Integer> outputs = new ArrayList<>();
        for (String pos : positions){
            outputs.add(findStepsToZ(pos));
        }


//        positions.add("AAA");
//        System.out.println(positions);
//        System.out.println(positions1);
    }
}