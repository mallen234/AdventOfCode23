import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class Pair implements Comparable<Pair>{
    private String hand;
    private int bet;

    public Pair(String hand, int bet) {
        this.bet = bet;
        this.hand = hand;
    }

    public String getHand() {
        return hand;
    }

    public int getBet() {
        return bet;
    }



    @Override
    public String toString() {
        return (hand + " " + (getBet()));
    }

    private static boolean isOriginalTwoPair(String hand){
        HashMap<Character,Integer> val = new HashMap<>();
        for (char card : hand.toCharArray()){
            val.merge(card , 1,Integer::sum);
        }
        int twoPair = Collections.frequency(val.values(), 2);
        return twoPair == 2;
    }

    private static boolean isTwoPair(String hand){
        HashMap<Character,Integer> val = new HashMap<>();
        for (char card : hand.toCharArray()){
            val.merge(card , 1,Integer::sum);
        }
        int twoPair = Collections.frequency(val.values(), 2);
        if (val.get('J') == null){
            return (twoPair == 2);
        } else if (val.get('J') == 1){
            return twoPair == 1;
        } else {
            return true;
        }
    }
    private static boolean isFullHouse(String hand){
        HashMap<Character,Integer> val = new HashMap<>();
        for (char card : hand.toCharArray()){
            val.merge(card , 1,Integer::sum);
        }
        if (val.get('J') == null || val.get('J') == 3 ){
            return (val.containsValue(3) & val.containsValue(2));
        } else if (val.get('J') == 1){
            return isOriginalTwoPair(hand);
        } else{
            return false;
        }

    }
    private static int numberOfSameCard(String hand){
        HashMap<Character,Integer> val = new HashMap<>();
        for (char card : hand.toCharArray()){
            val.merge(card , 1,Integer::sum);
        }
        int jokerValue = 0;
        if (val.get('J') != null){
            jokerValue = val.get('J');
            val.put('J',0);
        }
        return (Collections.max(val.values()) + jokerValue);
    }

    private static int compareHighCard(String hand1, String hand2){
        HashHand hashHand = new HashHand();
        char[] charHand1 = hand1.toCharArray();
        char[] charHand2 = hand2.toCharArray();

        for (int i = 0; i < 5 ; i++){
            if (!Objects.equals(hashHand.getValue(charHand1[i]), hashHand.getValue(charHand2[i]))){
                return hashHand.getValue(charHand1[i]) - hashHand.getValue(charHand2[i]);
            }
        }
        return 0;

    }


    @Override
    public int compareTo(Pair p2) {
        String hand1 = getHand();
        String hand2 = p2.getHand();

        int maxHand1 = numberOfSameCard(hand1);
        System.out.println(this);
        int maxHand2 = numberOfSameCard(hand2);
        System.out.println(p2);
        System.out.printf("Max Hand 1: %s%nMax Hand 2: %s%n", maxHand1, maxHand2);


        if (maxHand1 != maxHand2){
            return maxHand1 - maxHand2;
        } else if (maxHand1 == 3){
            if (isFullHouse(hand1) ^ isFullHouse(hand2)){
                return isFullHouse(hand1) ? 1 : -1;
            }
            else return compareHighCard(hand1,hand2);

        }  else if (maxHand1 == 2){
            if (isTwoPair(hand1) ^ isTwoPair(hand2)){
                return isTwoPair(hand1) ? 1 : -1;
            }
            else return compareHighCard(hand1,hand2);
        } else{
            return compareHighCard(hand1,hand2);
        }

    }
}