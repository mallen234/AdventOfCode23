import java.util.*;

public class PokerHandComparator implements Comparator<Pair> {

    private static boolean isTwoPair(String hand){
        HashMap<Character,Integer> val = new HashMap<>();
        for (char card : hand.toCharArray()){
            val.merge(card , 1,Integer::sum);
        }
        int twoPair = 0;
        for (Integer counts : val.values()){
            if (counts == 2){
                twoPair ++;
            }
        }
        return (twoPair == 2);
    }
    private static boolean isFullHouse(String hand){
        HashMap<Character,Integer> vals = new HashMap<>();
        for (char card : hand.toCharArray()){
            vals.merge(card , 1,Integer::sum);
        }
        return (vals.containsValue(3) & vals.containsValue(2));
    }
    private static int numberOfSameCard(String hand){
        HashMap<Character,Integer> vals = new HashMap<>();
        for (char card : hand.toCharArray()){
            vals.merge(card , 1,Integer::sum);
        }
        int jokerValue = 0;
//        if (vals.get('J') != null){
//            jokerValue = vals.get('J');
//            vals.put('J',0);
//        }
        return (Collections.max(vals.values()) + jokerValue );
    }

    private static int compareHighCard(String hand1, String hand2){
        HashHand hashHand = new HashHand();
        char[] charHand1 = hand1.toCharArray();
        char[] charHand2 = hand2.toCharArray();

        for (int i = 0; i < 5 ; i++){
            if (hashHand.getValue(charHand1[i]) != hashHand.getValue(charHand2[i])){
                return hashHand.getValue(charHand1[i]) - hashHand.getValue(charHand2[i]);
            }
        }
        return 0;

    }

    @Override
    public int compare(Pair p1, Pair p2) {
        String hand1 = p1.getHand();
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
