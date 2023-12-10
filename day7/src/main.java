import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class main {

    public static Pair parseStringArrayToPair(String[] stringArray) {
        String hand = stringArray[0];
        int bet = Integer.parseInt(stringArray[1]);
        return new Pair(hand,bet);
    }

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("input.txt"));
//        System.out.println(lines);
        List<Pair> hands = new ArrayList<>();
        for (String s : lines){
            String[] strHand = s.split(" ");
            Pair hand = parseStringArrayToPair(strHand);
            hands.add(hand);
        }

        char[] ch = hands.get(3).getHand().toCharArray();

        HashMap<Character,Integer> vals1 = new HashMap<>();
        for (char card : ch){
            vals1.merge(card , 1,Integer::sum);
        }
        int maxValueInMap = (Collections.max(vals1.values()));
//        System.out.println(maxValueInMap);

        HashHand hh = new HashHand();
//        System.out.println(hh.getValue('2'));

        PokerHandComparator pokerComparator  = new PokerHandComparator();
        PriorityQueue<Pair> sortedHands = new PriorityQueue<>(pokerComparator);
        sortedHands.addAll(hands);
        System.out.println(sortedHands);
        System.out.println(sortedHands.peek());



//        System.out.println(hands);
//        Collections.sort(hands);
//        System.out.println(hands);

//        System.out.println(pokerComparator.compare(hands.get(2),hands.get(6)));
//        int tot = 0;
//        for (int i = 0;  i < hands.size(); i++){
//            int j = i+1;
//            System.out.println(hands.get(i) + " " + j);
//            tot += hands.get(i).getBet() * (i+1);
//        }
//        System.out.println(tot);


    }
}
