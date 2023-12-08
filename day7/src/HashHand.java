import java.util.HashMap;

public class HashHand {
    private HashMap<Character,Integer> handValue = new HashMap<>();

    HashHand(){
        handValue.put('A', 14);
        handValue.put('K', 13);
        handValue.put('Q', 12);
        handValue.put('J', 1);
        handValue.put('T', 10);
        handValue.put('9', 9);
        handValue.put('8', 8);
        handValue.put('7', 7);
        handValue.put('6', 6);
        handValue.put('5', 5);
        handValue.put('4', 4);
        handValue.put('3', 3);
        handValue.put('2', 2);
    }

    public Integer getValue(Character key){
        return handValue.get(key);
    }
}
